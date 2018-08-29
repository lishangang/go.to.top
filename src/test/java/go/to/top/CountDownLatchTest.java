package go.to.top;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		Thread1 t1 = new Thread1(latch);
		t1.start();
		try {
			latch.await();
			System.out.println("轮到我了吧");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Thread1 extends Thread {

	private final CountDownLatch latch;
	public Thread1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("等我处理完");
		try {
			Thread.sleep(1000*5);
			latch.countDown();
			System.out.println("我处理完了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
