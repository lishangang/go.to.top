package com.top.base.lock;

public class DeadLock {

	class Task extends Thread {
		private Object own;
		private Object other;
		public Task(Object own, Object other) {
			this.own = own;
			this.other = other;
		}
		@Override
		public void run() {
			synchronized(own) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (other) {
					System.out.println(Thread.currentThread().getName() + "获取了对方的锁，打印数据");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		DeadLock.Task t1 = new DeadLock().new Task(o1, o2);
		DeadLock.Task t2 = new DeadLock().new Task(o2, o1);
		t1.start();
		t2.start();
	}
}
