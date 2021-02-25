package Live07_0222;

public class CoronaThreadTest5 extends Thread {
	int num;
	
	public CoronaThreadTest5(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		try{
			System.out.println("thread try start"); 
			Thread.sleep(5000);  
			System.out.println("thread try end");  
		}catch(InterruptedException e){
			System.out.println("thread interrupted raised"); 
		}
		System.out.println(num);
	}
	public static void main(String[] args) {
		CoronaThreadTest5 t = new CoronaThreadTest5(2020);
		t.start();
		t.interrupt();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End!!");
	}
	
}
