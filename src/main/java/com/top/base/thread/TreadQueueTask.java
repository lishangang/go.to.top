package com.top.base.thread;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TreadQueueTask {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1000);
		final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
		for (int i = 0; i < 100000; i++) {
			queue.add(i);
		}
		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(1000));
			for (int i = 0; i < 1000; i++) {
				//executor.execute(new ThreadTask(queue, latch));
				executor.submit(new ThreadTask(queue, latch));
			}
			latch.await();
			System.out.println("执行结束");
			executor.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class ThreadTask implements Runnable {

	private ConcurrentLinkedQueue<Integer> queue;
	
	private CountDownLatch latch;
	
	public ThreadTask(ConcurrentLinkedQueue<Integer> queue, CountDownLatch latch) {
		this.queue = queue;
		this.latch = latch;
	}

	@Override
	public void run() {
		while(true) {
			Integer data = queue.poll();
			if (data == null) {
				latch.countDown();
				break;
			}
			System.out.println(Thread.currentThread().getName() + "-- "+ data);
		}
	}
	
}
