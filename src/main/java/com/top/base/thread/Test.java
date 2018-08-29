package com.top.base.thread;

public class Test {
	

	public static void main(String[] args) {
		final T1 t = new T1();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				System.out.println(t.incr());
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				System.out.println(t.incr());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				System.out.println(t.incr());
			}
		});
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
					System.out.println(t.incr());
			}
		}).start();;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
					System.out.println(t.incr());
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
					System.out.println(t.incr());
			}
		}).start();
		t1.start();t2.start();t3.start();
	}
}

class T1 {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public int incr() {
		return a++;
	}
	
}
