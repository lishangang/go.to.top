package com.top.spring.aop.test;

public class Print implements IPrint {

	@Override
	public void print(String name) {
		System.out.println("打印你的名字：" + name);
	}
	
	public void print2(String name) {
		System.out.println("我是自定义的方法:" + name);
	}

}
