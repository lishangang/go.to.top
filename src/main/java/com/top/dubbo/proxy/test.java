package com.top.dubbo.proxy;

import com.top.dubbo.interface_.IHelloWorldService;
import com.top.dubbo.interface_.impl.HelloWorldService;
import com.top.dubbo.proxy.client.RPCProxyClient;

public class test {

	public static void main(String[] args) {
		IHelloWorldService service = (IHelloWorldService) RPCProxyClient.getProxy(new HelloWorldService());
		service.sayHello("--小明");
	}
}
