package com.top.dubbo.interface_.impl;

import com.top.dubbo.interface_.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {

	@Override
	public void sayHello(String hello) {
		System.out.println("Hello World " + hello);
	}

}
