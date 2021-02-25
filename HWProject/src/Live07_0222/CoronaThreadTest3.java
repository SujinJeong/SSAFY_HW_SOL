package Live07_0222;

public class CoronaThreadTest3 extends Thread {
	int num;
	
	public CoronaThreadTest3(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		
		for( int i=0; i< 10000; i++ ) {
			if( i == 5000 && num % 2 == 0 ) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(num);
	}
	public static void main(String[] args) {
		
		for( int t=0; t<1000; t++ ) {
			
			CoronaThreadTest3 thread = new CoronaThreadTest3(t);
			thread.start();
			
		}
	}
}