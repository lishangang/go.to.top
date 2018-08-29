package com.top.base.lock;

public class TurnPrint1_100_2 {
	
	public volatile int count = 0;
	
	class Task extends Thread {
		private Object self;
		private Object next;
		private TurnPrint1_100_2 t;
		
		public Task(Object self, Object next, TurnPrint1_100_2 t) {
			this.self = self;
			this.next = next;
			this.t = t;
		}
		
		@Override
		public void run() {
			while (t.count < 100) {
				synchronized(self) {
					synchronized(next) {
						System.out.println(Thread.currentThread().getName() + "_" + t.count++);
						next.notify();
					}
					try {
						self.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		Object o2 = new Object();
		TurnPrint1_100_2 t = new TurnPrint1_100_2();
		Task t1 = new TurnPrint1_100_2().new Task(o1, o2, t);
		Task t2 = new TurnPrint1_100_2().new Task(o2, o1, t);
		t1.start();
		Thread.sleep(10);
		t2.start();
	}
}
