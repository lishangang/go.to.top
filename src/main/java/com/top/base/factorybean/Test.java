package com.top.base.factorybean;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-app.xml"})
@WebAppConfiguration
public class Test {

	@Autowired
	WebApplicationContext wc;
	
	@org.junit.Test
	public void getBean() {
		Person person = (Person) wc.getBean("person");
		person.sayName();
	}
}
