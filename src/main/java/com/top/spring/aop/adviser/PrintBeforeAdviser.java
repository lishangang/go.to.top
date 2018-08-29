package com.top.spring.aop.adviser;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class PrintBeforeAdviser implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("打印前搞点事情，打印的目标对象：" + target.getClass().getSimpleName() 
				+ "; 打印的方法名：" + method.getName() + "; 方法参数为：" + Arrays.toString(args));
	}

}
