package com.top.spring.aop.adviser;

public class TransactionAspect {

	public void beginTransaction() {
		System.out.println("开启事务");
	}
	
	public void commitTransaction() {
		System.out.println("提交事物");
	}
	
	public void rollBackTransaction() {
		System.out.println("事物回滚");
	}
}
