package com.top.base.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock的Condition功能
 * synchronized 对应Object的wait、nodity等，ReentrantLock对应Condition的await、signal
 */
public class ReentrantLockWithCondition implements Runnable {

	public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition condition = lock.newCondition();
    
	@Override
	public void run() {
		try {
			lock.lock();
			System.err.println(Thread.currentThread().getName() + "-线程开始等待...");
			condition.await();
			System.err.println(Thread.currentThread().getName() + "-线程继续进行了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockWithCondition test = new ReentrantLockWithCondition();
        Thread t = new Thread(test, "线程ABC");
        t.start();
        Thread.sleep(1000);
        System.err.println("过了1秒后...");
        lock.lock();
        condition.signal();
        lock.unlock();
	}
}
