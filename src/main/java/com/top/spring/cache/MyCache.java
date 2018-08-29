package com.top.spring.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class MyCache implements Cache {

	private String name;
	private ConcurrentMap<Object, Object> store = new ConcurrentHashMap<Object, Object>(); 
	
	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueWrapper get(Object key) {
		System.out.println("我开始从缓存中查，看有没有嘿嘿。。。");
		Object thevalue = store.get(key);
		if (thevalue != null) {
			System.out.println("缓存中有。。。。");
			return new SimpleValueWrapper(thevalue);
		}
		System.out.println("缓存中没有。。。");
		return null;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		Object thevalue = store.get(key);
		if (thevalue != null) {
			return type.cast(thevalue);
		}
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		Assert.notNull(key, "key is not null");
		if (key instanceof String && !StringUtils.hasText(key.toString())) {
			throw new IllegalArgumentException("key is not blank");
		}
		store.put(key, value);
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void evict(Object key) {
		store.remove(key);
	}

	@Override
	public void clear() {
		System.out.println("清空全部缓存数据");
		store.clear();
	}

}
