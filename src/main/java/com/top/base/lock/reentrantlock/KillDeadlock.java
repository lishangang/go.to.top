package com.top.base.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock的锁中断响应
 *
 */
public class KillDeadlock implements Runnable {

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;

	public KillDeadlock(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				// 设置可中断锁
				lock1.lockInterruptibly();
				Thread.sleep(500);
				lock2.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "活下来了");
			} else {
				lock2.lockInterruptibly();
				Thread.sleep(500);
				lock1.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "活下来了");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.err.println(Thread.currentThread().getName()+ "退出！");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		KillDeadlock deadLock1 = new KillDeadlock(1);
		KillDeadlock deadLock2 = new KillDeadlock(2);
		Thread t0 = new Thread(deadLock1);
		Thread t1 = new Thread(deadLock2);
		t0.start();
		t1.start();
		Thread.sleep(1000);
		// 中断线程
		//t1.interrupt();
	}

}
