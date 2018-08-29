package com.top.spring.aop.adviser;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PrintAfterdviser implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("打印完成，我做个总结：嗯，不错" + method.getName());
		
	}

}
