package com.top.base.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonFactoryBean implements FactoryBean<Person>, InitializingBean {

	private String name;
	public void setName(String name) {
		this.name = name;
	}
	private Person person;
	
	@Override
	public Person getObject() throws Exception {
		return this.person;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if ("xiaoming".equals(name)) {
			person = new Xiaoming();
		} else if ("xiaohong".equals(name)) {
			person = new Xiaohong();
		}
	}

}
