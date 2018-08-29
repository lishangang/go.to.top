package com.top.dubbo.proxy.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RPCProxyClient implements InvocationHandler {

	private Object object;
	
	public RPCProxyClient(Object object) {
		this.object = object;
	}
	
	public static Object getProxy(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new RPCProxyClient(object));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进行一些前期操作");
		Object result = method.invoke(object, args);
		System.out.println("进行一些后期操作");
		return result;
	}

}
