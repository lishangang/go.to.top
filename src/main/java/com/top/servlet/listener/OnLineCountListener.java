package com.top.servlet.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听在线人数
 */
public class OnLineCountListener implements HttpSessionListener {

	private AtomicInteger it = new AtomicInteger(0);
	
	@Override
	public void sessionCreated(HttpSessionEvent httpsessionevent) {
		System.out.println("监听器-有人上线");
		httpsessionevent.getSession().getServletContext().setAttribute("onlineCount", it.incrementAndGet());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {
		System.out.println("监听器-有人下线");
		httpsessionevent.getSession().getServletContext().setAttribute("onlineCount", it.decrementAndGet());
	}

}
