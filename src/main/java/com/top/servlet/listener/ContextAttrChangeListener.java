package com.top.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttrChangeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("监听器-增加-context属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("监听器-移除-context属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("监听器-替换-context属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

}
