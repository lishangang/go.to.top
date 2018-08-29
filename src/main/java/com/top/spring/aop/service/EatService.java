package com.top.spring.aop.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class EatService implements IEatService {

	public void eat() {
		System.out.println("吃饭中。。。");
	}
	
	public void eat2() {
		System.out.println("测试同一个类中调用其它方法能否织入切面，此处应该打印两次饭前喝汤，之后两次饭后喝汤");
		// 获取当前动态代理之后调用eat方法
		((IEatService)AopContext.currentProxy()).eat();
	}
}
