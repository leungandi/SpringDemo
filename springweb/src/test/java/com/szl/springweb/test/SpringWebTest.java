package com.szl.springweb.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springorm.service.impl.UserServiceImpl;
import com.szl.springweb.util.ApplicationContextUtil;


public class SpringWebTest {
	

	ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	}

	@Test
	public void test() {
		UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("SpringWeb:"+queryUser.toString());
	}
	@Test
	public void test1() {
		UserServiceImpl userDaoImpl = ApplicationContextUtil.getApplicationContext().getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("SpringWeb1:"+queryUser.toString());
	}
	
	/**
	 * 
	 * 测试从ApplicationContextAware中获取上下文bean
	 */
	@Test
	public void testApplicationContextAware(){
		UserServiceImpl userDaoImpl = ApplicationContextUtil.getApplicationContext().getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("SpringWeb:"+queryUser.toString());
	}

}
