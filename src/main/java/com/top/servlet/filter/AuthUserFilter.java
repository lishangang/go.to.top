package com.top.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ObjectUtils;

import com.top.spring.mvc.bean.User;

public class AuthUserFilter implements Filter {
	
	private String[] ignorUrls;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String sessionId = "";
		Cookie[] cookies = request.getCookies();
		if (!ObjectUtils.isEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if ("JSESSIONID".equals(cookie.getName())) {
					sessionId = cookie.getValue();
				}
			}
		}
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		Object obj = null;
		if (StringUtils.isNotBlank(sessionId)) {
			obj = session.getAttribute(sessionId);
		}
		if (obj != null && obj instanceof User) {
			User user = (User) obj;
			System.out.println("用户访问" + user.toString());
		} else if (!containsIgnorUrl(uri)) {
			response.sendRedirect("login.do");
			return;
		}
		arg2.doFilter(arg0, arg1);
	}
	
	private boolean containsIgnorUrl(String uri) {
		if (!ObjectUtils.isEmpty(ignorUrls)) {
			for (String ignorUrl : ignorUrls) {
				if (uri.contains(ignorUrl.trim())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 可初始化xml中配置的参数
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		String ignorUrls = config.getInitParameter("ignorUrls");
		if (StringUtils.isNotBlank(ignorUrls)) {
			this.ignorUrls = ignorUrls.split(",");
		}
	}
	
	/** 
	 * 这个方法在过滤器即将终止服务之前，由Servlet调用，一般发生在应用程序停止的时候。
	 * 当然了暴力杀死进程肯定是无法执行的。
	 */
	@Override
	public void destroy() {
		System.out.println("过滤器-应用程序停止-过滤器即将停止服务");
	}

}
