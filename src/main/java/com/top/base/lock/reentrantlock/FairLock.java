package com.top.base.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试公平锁
 */
public class FairLock implements Runnable {
	
	private static ReentrantLock lock = new ReentrantLock(true);
	private volatile int i;
	@Override
	public void run() {
		while(true) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + "-" + (i++));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		FairLock lock1 = new FairLock();
		new Thread(lock1).start();
		new Thread(lock1).start();
	}

}
