package com.top.spring.cache.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.top.spring.cache.bean.Account;
import com.top.spring.cache.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-cache.xml"})
public class Test {

	@Autowired
	private AccountService accountService;
	
	@org.junit.Test
	public void testGetAccountCache() {
		Account a1 = accountService.getAccountByName("小明");
		System.out.println(a1.toString());
		accountService.reload(); //执行reload后，会清空accountCache关键字下的所有缓存
		Account a2 = accountService.getAccountByName("小明");
		System.out.println(a2.toString());
	}
	
}
