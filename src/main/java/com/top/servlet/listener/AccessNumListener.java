package com.top.servlet.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class AccessNumListener implements ServletRequestListener {

	private AtomicInteger ai = new AtomicInteger(0);
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("监听器-请求结束，我是统计访问量的监听器");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("监听器-请求来了，我是统计访问量的监听器");
		// 可以分别对指定的url进行单独的统计
		arg0.getServletContext().setAttribute("accessNum", ai.incrementAndGet());
	}

}
