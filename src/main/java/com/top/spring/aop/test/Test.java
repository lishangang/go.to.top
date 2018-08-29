package com.top.spring.aop.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.top.spring.aop.service.IEatService;
import com.top.spring.aop.service.IUserService;

/**
 * spring aop配置测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-aop.xml"})
public class Test {
	
	@Resource
	private IPrint print;
	
	@Resource
	private IUserService userService;
	
	@Autowired
	private IEatService eatService;

	/**
	 * 测试spring aop代理模式配置
	 */
	@org.junit.Test
	public void print() {
		print.print("小明");
		System.out.println(print.getClass());
	}
	
	/**
	 * 测试spring aop纯切面方式配置
	 */
	@org.junit.Test
	public void testAop2() {
		userService.insertUser();
		userService.deleteUser();
		//userService.addUser();
		System.out.println(userService.getClass().getName());
	}
	
	/**
	 * 测试AspectJ注解方式配置
	 */
	@org.junit.Test
	public void testAop3() {
		eatService.eat();
		System.out.println(eatService.getClass().getName());
	}
	
	/**
	 * 测试AspectJ注解方式配置
	 */
	@org.junit.Test
	public void testAop4() {
		eatService.eat2();
		System.out.println(eatService.getClass().getName());
	}
}
