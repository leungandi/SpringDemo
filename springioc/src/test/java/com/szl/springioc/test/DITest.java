package com.szl.springioc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springioc.dao.HelloIoc;
import com.szl.springioc.dao.impl.HelloIocImpl;
import com.szl.springioc.model.Collections;
import com.szl.springioc.model.User;


public class DITest {
	ApplicationContext ac;
	@Before
	public void init(){
		//读取配置文件从而实例化IOC容器
		ac = new ClassPathXmlApplicationContext("DI_test.xml");
	}

	@Test
	public void testDI() {
		//测试无参构造注入
//		User user = ac.getBean("user",User.class);
//		System.out.println(user.toString());
		
		//测试有参构造注入
//		User user1 = ac.getBean("user1",User.class);
//		System.out.println(user1.toString());
		
		//测试setter注入
		User user2 = ac.getBean("user2",User.class);
		System.out.println(user2.toString());

	}
	@Test
	public void testDIForCollections() {
		//测试setter注入
//		Collections collectionsBoolean = ac.getBean("collectionsBoolean",Collections.class);
//		System.out.println(collectionsBoolean.toString());
		//测试List注入
//		Collections collectionsList = ac.getBean("collectionsList",Collections.class);
//		System.out.println(collectionsList.toString());
		//测试Map注入
//		Collections collectionsMap = ac.getBean("collectionsMap",Collections.class);
//		System.out.println(collectionsMap.toString());
		//测试Map注入
//		Collections collectionsSet = ac.getBean("collectionsSet",Collections.class);
//		System.out.println(collectionsSet.toString());
		//测试p命名空间注入
		Collections collectionsP = ac.getBean("collectionsP",Collections.class);
		System.out.println(collectionsP.toString());
		
	}
	
	
}
