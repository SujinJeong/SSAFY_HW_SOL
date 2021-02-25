package Live07_0222;

public class CoronaThreadTest2 {
	public static void main(String[] args) {

		System.out.println("before Thread.sleep()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after Thread.sleep()");

	}
}
