package com.top.spring.aop.component;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义注解切面，增强用户吃饭
 */
@Component
@Aspect
public class AnnotationEatAdvisor {

	/**
	 * 定义一个切点
	 */
	@Pointcut(value = "execution(* com.top.spring.aop.service.EatService.*(..))")
	public void pointCut(){};
	
	@Before("pointCut()")
	public void beforeEat() {
		System.out.println("饭前喝汤");
	}
	
	@After("pointCut()")
	public void afterEat() {
		System.out.println("饭后喝汤");
	}
}
