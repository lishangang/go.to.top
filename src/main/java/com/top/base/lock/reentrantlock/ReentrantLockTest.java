package com.top.base.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int i;
	
	@Override
	public void run() {
		for (int j = 0; j < 10000; j++) {
            lock.lock(); 
            //lock.lock(); 可重入锁，一个lock，需要对应一个unlock
            try {
                i++;
                System.out.println(Thread.currentThread().getName() + "-" + i);
            } finally {
                lock.unlock();
                //lock.unlock(); 可重入锁，一个lock，需要对应一个unlock
            }
        }
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();t2.start();
        t1.join(); t2.join();
        System.err.println(i);
	}

}
