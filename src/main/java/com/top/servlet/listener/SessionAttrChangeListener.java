package com.top.servlet.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听session属性变化
 */
public class SessionAttrChangeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("监听器-增加-session属性:{name:" + httpsessionbindingevent.getName() +", value:" + httpsessionbindingevent.getValue() + "}");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("监听器-移除-session属性:{name:" + httpsessionbindingevent.getName() +", value:" + httpsessionbindingevent.getValue() + "}");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("监听器-替换-session属性:{name:" + httpsessionbindingevent.getName() +", value:" + httpsessionbindingevent.getValue() + "}");
	}

}
