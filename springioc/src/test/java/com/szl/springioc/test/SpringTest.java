package com.szl.springioc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springioc.dao.HelloIoc;
import com.szl.springioc.dao.impl.HelloIocImpl;


public class SpringTest {
	ApplicationContext ac;
	@Before
	public void init(){
		//读取配置文件从而实例化IOC容器
		ac = new ClassPathXmlApplicationContext("HelloIoc.xml");
	}

	@Test
	public void testHello() {
		//从容器中获取bean
		HelloIoc hi = (HelloIocImpl) ac.getBean("helloIoc");
		//执行业务逻辑
		hi.sayHello();
	}
	
	@Test
	public void testBean(){
		//测试bean使用id
		HelloIoc hiId = (HelloIocImpl) ac.getBean("helloIoc");
		hiId.sayHello();
		
		//测试bean使用name
		HelloIoc hiName = (HelloIocImpl) ac.getBean("helloIocName");
		hiName.sayHello();
		
		//测试bean仅使用类的全限定名
		HelloIoc hi = ac.getBean(HelloIocImpl.class);
		hi.sayHello();
		
		//测试Bean同时使用id和name
		HelloIoc hiIdAndName = (HelloIocImpl) ac.getBean("helloIocSame");
		hiIdAndName.sayHello();
	}
}
