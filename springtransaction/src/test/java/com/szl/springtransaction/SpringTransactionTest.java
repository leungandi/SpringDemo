package com.szl.springtransaction;


import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.szl.springorm.service.impl.UserServiceImpl;


public class SpringTransactionTest {
	
	private ApplicationContext ac;
	
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("transaction_test.xml");
	}
	
	/**
	 * 使用PlatformTransactionManager
	 * @author SongZhangLiang
	 */
	@Test
	public void testPlatformTransactionManager(){
	 	PlatformTransactionManager ptm = ac.getBean("transactionManager",PlatformTransactionManager.class);
	 	UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
	 	//定义事务属性
	 	DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
	 	//设置隔离级别
	 	dtd.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_DEFAULT);
		//设置传播行为
	 	dtd.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
	 	//获取事务状态
	 	TransactionStatus ts = ptm.getTransaction(dtd);
		List<Map<String, Object>> queryUser;
		try {
			//业务逻辑的处理
			queryUser = userDaoImpl.queryUser();
			System.out.println("testPlatformTransactionManager:"+queryUser.toString());
			//提交
			ptm.commit(ts);
		} catch (Exception e) {
			//回滚
			ptm.rollback(ts);
		}	
	}
	
	/**
	 * 使用TransactionTemplate
	 * @author SongZhangLiang
	 */
	@Test
	public void testTransactionTemplate(){
		UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		//获取TransactionTemplate
		TransactionTemplate tt = ac.getBean("transactionTemplate",TransactionTemplate.class);
				List<Map<String, Object>> queryUser = tt.execute(new TransactionCallback<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> doInTransaction(TransactionStatus status) {
				//业务逻辑的处理
				try {
					return userDaoImpl.queryUser();
				} catch (Exception e) {
					//异常回滚
					status.setRollbackOnly();
				}
				return null;
			}
		});
		System.out.println("testTransactionTemplate:"+queryUser.toString());
	}
	
	/**
	 * 声明式事务测试
	 * @author SongZhangLiang
	 */
	@Test
	public void testTransaction(){
		UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("testPlatformTransactionManager:"+queryUser.toString());
	}
	/**
	 * 声明式事务测试_注解
	 * @author SongZhangLiang
	 */
	@Test
	public void testTransactionAnnotation(){
		com.szl.springtransaction.service.impl.UserServiceImpl userDaoImpl = ac.getBean("userServiceImpl1",com.szl.springtransaction.service.impl.UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userDaoImpl.queryUser();
		System.out.println("testTransactionAnnotation:"+queryUser.toString());
	}
	
	

}
