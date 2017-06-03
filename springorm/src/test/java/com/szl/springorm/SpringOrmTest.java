package com.szl.springorm;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szl.springorm.dao.UserDao;
import com.szl.springorm.dao.impl.UserDaoImpl;
import com.szl.springorm.service.impl.UserServiceImpl;


public class SpringOrmTest {
	
	private ApplicationContext ac;
	
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("orm_test.xml");
	}
	
	/**
	 * 使用SqlSession进行数据库操作
	 * @author SongZhangLiang
	 */
	@Test
	public void testSqlSession() {
		/**
		 * 直接使用SqlSession进行数据库操作（使用指定的完全限定名“com.szl.springorm.dao.UserDao.queryUser”来调用映射语句）
		 */
		SqlSession ss = null;
		try {
			SqlSessionFactory ssf = ac.getBean("sqlSessionFactory",SqlSessionFactory.class);
			ss = ssf.openSession();
			List<Map<String, Object>> selectList = ss.selectList("com.szl.springorm.dao.UserDao.queryUser");
			System.out.println("testSqlSession:"+selectList.toString());
			ss.commit();
		} catch (Exception e) {
			//异常回滚
			System.out.println("异常："+e);
			ss.rollback();
		}
		finally {
			if(null != ss)
				ss.close();
		}
		/**
		 * 直接使用SqlSession进行数据库操作（使用Mapper 接口）
		 */
//		UserDao mapper = ss.getMapper(UserDao.class);
//		System.out.println("mapper:"+mapper.queryUser().toString());
	}
	
	/**
	 * 使用SqlSessionTemplate进行数据库操作
	 * SqlSessionTemplate 是 MyBatis-Spring 的核心。
	 * 这个类负责管理 MyBatis 的 SqlSession, 调用 MyBatis 的 SQL 方法, 翻译异常。 SqlSessionTemplate 是线程安全的, 可以被多个 DAO 所共享使用
	 */
	@Test
	public void testSqlSessionTemplate(){
		SqlSession ss = ac.getBean("sqlSessionTemplate",SqlSession.class);
		List<Map<String, Object>> selectList = ss.selectList("com.szl.springorm.dao.UserDao.queryUser");
		System.out.println("testSqlSessionTemplate:"+selectList.toString());
	}
	
	/**
	 * 使用SqlSessionDaoSupport进行数据库操作
	 * DAO的实现类必须要继承SqlSessionDaoSupport
	 * @author SongZhangLiang
	 */
	@Test
	public void testSqlSessionDaoSupport(){
		UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl",UserDaoImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("testSqlSessionDaoSupport:"+queryUser.toString());
	}
	
	
	
	/**
	 * 使用MapperFactoryBean代理
	 * 注意在这段代码中没有 SqlSession 或 MyBatis 的引用。也没有任何需要创建,打开或 关闭 session 的代码,MyBatis-Spring 会来关心它的。
	 * @author SongZhangLiang
	 */
	@Test
	public void testMapperFactoryBean(){
		UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("testMapperFactoryBean:"+queryUser.toString());
	}


}
