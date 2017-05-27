package com.szl.springioc.dao.impl;

import com.szl.springioc.dao.HelloIoc;

public class HelloIocImpl implements HelloIoc{

	@Override
	public void sayHello() {
		System.out.println("hello Ioc");
	}

	
} 
