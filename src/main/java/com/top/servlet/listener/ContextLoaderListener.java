package com.top.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 应用级监听器，只在应用启动和消亡时被调用
 */
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("监听器-context消亡-应用停止时执行");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("监听器-context初始化-应用启动时执行");
		System.out.println("监听器-context获取初始化参数contextTestParam：" + arg0.getServletContext().getInitParameter("contextTestParam"));
	}

}
