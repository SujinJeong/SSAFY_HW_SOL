package Live07_0222;

public class CoronaThreadTest4 extends Thread {
	int num;
	
	public CoronaThreadTest4(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(num);
	}
	public static void main(String[] args) {
		
		System.out.println("Main Thread Start!!");
		
		CoronaThreadTest4 thread = new CoronaThreadTest4(2020);
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End!!");
	}
}
