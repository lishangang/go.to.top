package com.top.spring.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.top.spring.cache.bean.Account;

@Service
public class AccountService {

	/**
	 * 条件：只给小明做缓存，还可以写其它代码，比如accountName.length() < 3
	 * @param accountName
	 * @return
	 */
	@Cacheable(value="accountCache",condition="#accountName.equals(\"小明\")")
	public Account getAccountByName(String accountName) {
		System.out.println("假设从数据库查询");
		Account account = new Account();
		account.setName(accountName);
		account.setId(11);
		return account;
	}
	
	/**
	 * 清空accountCache下所有的缓存数据
	 * beforeInvocation ：在执行方法体之前还是之后执行清空缓存，true之前，false缺省之后
	 */
	@CacheEvict(value="accountCache",allEntries=true,beforeInvocation=true)
	public void reload() {
		System.out.println("我要清空缓存，嘿嘿，你猜清空缓存是在我之前清空，还是在我之后？哈哈，由这个参数beforeInvocation控制，true就是在前，默认false，在后");
	}
	
	/**
	 * 更新账户后，清空该账户的缓存信息，key以#开头
	 */
	@CacheEvict(value="accountCache", key="#accountName")
	public void updateAccount(String accountName) {
		System.out.println("修改数据库数据");
	}
	
	/**
	 * 更新账户后，清空该账户的缓存信息，key中填写要获取key的代码，以#开头
	 */
	@CacheEvict(value="accountCache", key="#account.getName()")
	public void updateAccount(Account account) {
		System.out.println("修改数据库数据");
	}
}
