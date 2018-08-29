package com.top.spring.mvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.top.spring.context.SpringContextHolder;
import com.top.spring.mvc.bean.User;

/**
 * 测试几种获取spring注册的bean的方式
 * 1、在单元测试时，给类加@WebAppConfiguration，然后自动注入webApplicationContext
 * 2、
 * 3、
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mvc.xml"})
@WebAppConfiguration
public class GetSpringBeanTest {

	@Autowired
	private WebApplicationContext wc;
	
	@Test
	public void getBean1() {
		User user = (User) wc.getBean("user");
		System.out.println(user.toString());
	}
	
	@Test
	public void getBean2() {
		User user = SpringContextHolder.getBean("user", User.class);
		System.out.println(user.toString());
	}
	
}
