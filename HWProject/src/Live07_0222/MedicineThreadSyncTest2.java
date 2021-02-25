package Live07_0222;

class MedicineThread2 extends Thread{
	Cell cell;
	
	public MedicineThread2(Cell cell) {
		this.cell = cell;
	}
	
	@Override
	public void run() {
		
		synchronized(cell) {
			
			if( cell.power < 500 ) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power + 100;
			}
	
			System.out.println("MedicineThread : " + cell.power);
		}
	}
}
//------------------------------------------------------------
public class MedicineThreadSyncTest2 {

	public static void main(String[] args) {
		Cell cell = new Cell();
		
		for( int i=0; i< 10; i++) {
			MedicineThread t = new MedicineThread(cell);
			t.start();
		}

		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}