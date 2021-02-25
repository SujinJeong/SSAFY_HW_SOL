package Live07_0222;

class CoronaThread extends Thread {
	int num;
	Cell cell;
	
	public CoronaThread(int num) {
		this.num = num;
	}
	
	public CoronaThread(Cell cell) {
		this.cell = cell;
	}
	
	@Override
	public void run() {
		synchronized(cell) {
			if( cell.power < 100 ) {
				try {
					cell.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if( cell.power >= 100 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power - 100;
				cell.notifyAll();
			}
		}
		System.out.println("CoronaThread : " + cell.power);
	}
}
class MedicineThread3 extends Thread{
	Cell cell;
	
	public MedicineThread3(Cell cell) {
		this.cell = cell;
	}
	
	@Override
	public void run() {
		
		synchronized(cell) {
			if( cell.power >= 500 ) {
				try {
					cell.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if( cell.power < 500 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power + 100;
				cell.notifyAll();
			}
	
			System.out.println("MedicineThread : " + cell.power);
		}
	}
}
public class MedicineThreadSyncTest3 {
	public static void main(String[] args) {
		Cell cell = new Cell();
		
		for( int i=0; i< 10; i++) {
			MedicineThread3 t = new MedicineThread3(cell);
			t.start();
		}
		
		for( int i=0; i< 10; i++) {
			CoronaThread t = new CoronaThread(cell);
			t.start();
		}

		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}