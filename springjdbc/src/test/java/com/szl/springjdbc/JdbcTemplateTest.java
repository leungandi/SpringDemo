package com.szl.springjdbc;


import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springjdbc.entity.User;
import com.szl.springjdbc.service.impl.UserServiceImpl;
import com.szl.springjdbc.util.JdbcUtil;

public class JdbcTemplateTest {
	
	private ApplicationContext ac;
	
	@Before
	public void inti() {
		ac = new ClassPathXmlApplicationContext("jdbc_test.xml");
	}
	
	/**
	 * 测试传统JDBC编程
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbc() {
		JdbcUtil bean = ac.getBean("jdbcTest",JdbcUtil.class);
		bean.JdbcTest();
	}
	
	
	/**
	 * 测试传统jdbcTemplate编程_查询
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbcTemplateQuery() {
		UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userServiceImpl.queryUser();
		System.out.println("查询数据："+queryUser.toString());
	}
	/**
	 * 测试传统jdbcTemplate编程_添加
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbcTemplateAdd() {
		UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		User user = new User();
		user.setName("李四");
		user.setEmail("lisi@foxmail.com");
		System.out.println("result:"+userServiceImpl.addUser(user));
	}
	
	/**
	 * 测试传统jdbcTemplate编程_删除
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbcTemplateDel() {
		UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		System.out.println("result:"+userServiceImpl.delUserById(1L));
	}

}
