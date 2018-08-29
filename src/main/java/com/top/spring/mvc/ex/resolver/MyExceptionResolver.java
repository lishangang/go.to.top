package com.top.spring.mvc.ex.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC全局异常处理器
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("我的异常处理器");
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("exception", ex);
		return mav;
	}

}
