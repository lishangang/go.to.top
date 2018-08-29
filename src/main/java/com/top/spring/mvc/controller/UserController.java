package com.top.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.top.spring.mvc.bean.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/create", method={RequestMethod.GET})
	public String create() {
		return "create";
		//throw new RuntimeException("我自己造了个异常");
	}
	
	@RequestMapping(value="/save", method={RequestMethod.POST})
	public String save(@ModelAttribute("form")User user, Model model) {
		model.addAttribute("user", user);
        return "detail";
	}
	
	@RequestMapping(value="/getUser", method={RequestMethod.GET})
	@ResponseBody
	public User getUser(String name, String pwd) {
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping(value="/hello", method={RequestMethod.GET})
	public String hello(Model model) {
		model.addAttribute("hello", "hello Mr.li");
		return "hello.vm";
	}
	
	@RequestMapping(value="/login")
	public String login(@ModelAttribute("form")User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (user != null && "123".equals(user.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute(session.getId(), user);
			session.setAttribute("user", user);
			response.sendRedirect("index.do");
		}
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/onlineCount")
	public String onlineCount(HttpServletRequest request) {
		//int count = (int) request.getServletContext().getAttribute("onlineCount");
		return "onlineCount";
	}
	
	@RequestMapping(value="/changeSessionAttribute")
	@ResponseBody
	public String changeSessionAttribute(@RequestParam("type")String type, HttpServletRequest request) {
		if ("add".equals(type)) {
			request.getSession().setAttribute("changeSessionAttribute", "1");
		} else if ("remove".equals(type)) {
			request.getSession().removeAttribute("changeSessionAttribute");
		} else if ("replace".equals(type)) {
			request.getSession().setAttribute("changeSessionAttribute", "2");
		}
		return "ok";
	}
	
	@RequestMapping(value="/queryAccessNum")
	@ResponseBody
	public String queryAccessNum(HttpServletRequest request) {
		return request.getServletContext().getAttribute("accessNum").toString();
	}
	
}
