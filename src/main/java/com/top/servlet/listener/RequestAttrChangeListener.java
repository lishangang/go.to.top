package com.top.servlet.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 监听request域的属性变化
 */
public class RequestAttrChangeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("监听器-增加-request属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("监听器-移除-request属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("监听器-替换-request属性:{name:" + arg0.getName() +", value:" + arg0.getValue() + "}");
	}

}
