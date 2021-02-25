package Live07_0222;

class CoronaRunnable implements Runnable {
	int num;
	
	public CoronaRunnable(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		
		System.out.println("#" + num + " is Started");
		for( int i=0; i<10000; i++ ) {
			int j = i*100;
		}
		System.out.println(num);
	}
}
public class CoronaThreadTest1 {
	public static void main(String[] args) {
		for( int t=0; t<1000; t++ ) {
			
			CoronaRunnable cr = new CoronaRunnable(t);
			Thread thread = new Thread(cr);
			thread.start();
			
		}
	}
}
