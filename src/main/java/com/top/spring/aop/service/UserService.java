package com.top.spring.aop.service;

public class UserService implements IUserService {

	public void insertUser() {
		System.out.println("插入用户");
	}
	
	public void deleteUser() {
		System.out.println("删除用户");
	}
	
	public void addUser() {
		System.out.println("添加用户");
		throw new RuntimeException();
	}
}
