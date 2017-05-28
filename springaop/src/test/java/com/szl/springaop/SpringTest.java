package com.szl.springaop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springaop.aop.AopLog;
import com.szl.springaop.service.UserService;
import com.szl.springaop.service.impl.UserServiceImpl;



public class SpringTest {
	ApplicationContext ac;
	@Before
	public void init(){
		//读取配置文件从而实例化IOC容器
		ac = new ClassPathXmlApplicationContext("aop_test.xml");
	}

	@Test
	public void testAdvice() {
		//从容器中获取bean
		UserService us = ac.getBean("userService",UserServiceImpl.class);
		//执行业务逻辑
		us.insetUser();
//		us.queryUser();
	}
	
	@Test
	public void testAdviceAspectJ() {
		//从容器中获取bean
		UserService us = ac.getBean("userService",UserServiceImpl.class);
		//执行业务逻辑
		us.insetUser();
//		us.queryUser();
	}

}
