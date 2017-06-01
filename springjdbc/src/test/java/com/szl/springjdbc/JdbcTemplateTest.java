package com.szl.springjdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.druid.pool.DruidDataSource;
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
	 * 测试spring JdbcTemplate
	 */
	@Test
	public void testSpringJdbc() throws IOException {
		//读取配置文件的数据源配置
		Properties properties = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
		properties.load(in);
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		String driver = properties.getProperty("jdbc.driver");
		//使用alibaba的DruidDataSource
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driver);
		dataSource.setInitialSize(2);
		dataSource.setMinIdle(2);
		dataSource.setMaxActive(10);
		dataSource.setMaxWait(60000);
		dataSource.setTimeBetweenEvictionRunsMillis(5000);
		dataSource.setMinEvictableIdleTimeMillis(120000);
		//new一个jdbctemplate
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		//测试查询
//		List<Map<String, Object>> queryForList = jt.queryForList("select * from t_users");
//		System.out.println("查询结果："+queryForList.toString());
		
		//测试增加
//		int update = jt.update("INSERT INTO t_users(name,email)VALUES('王五','wangwu@163.com')");
//		System.out.println("增加结果："+update);
		
		//测试RowMapper结果集回调
//		List<Map<String, Object>> query = jt.query("select * from t_users", new RowMapper<Map<String, Object>>() {
//			@Override
//			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Map<String, Object> result = new HashMap<>();
//				result.put("id", rs.getInt("id"));
//				result.put("name", rs.getString("name"));
//				result.put("email", rs.getString("email"));
//				return result;
//			}
//		});
//		System.out.println("RowMapper结果："+query.toString());
		
		//测试RowCallbackHandler结果集回调
//		List<Map<String, Object>> query = new ArrayList<>();
//		jt.query("select * from t_users",new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				Map<String, Object> result = new HashMap<>();
//				result.put("id", rs.getInt("id"));
//				result.put("name", rs.getString("name"));
//				result.put("email", rs.getString("email"));
//				query.add(result);
//			}
//		});
//		System.out.println("RowCallbackHandler结果："+query.toString());
	}
	
	
	/**
	 * 测试spring JdbcTemplate 结果集回调
	 */
	@Test
	public void testSpringJdbcResult() throws IOException {
		//读取配置文件的数据源配置
		Properties properties = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
		properties.load(in);
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		String driver = properties.getProperty("jdbc.driver");
		//使用alibaba的DruidDataSource
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driver);
		dataSource.setInitialSize(2);
		dataSource.setMinIdle(2);
		dataSource.setMaxActive(10);
		dataSource.setMaxWait(60000);
		dataSource.setTimeBetweenEvictionRunsMillis(5000);
		dataSource.setMinEvictableIdleTimeMillis(120000);
		//new一个jdbctemplate
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		//测试RowMapper结果集回调
//		List<Map<String, Object>> query = jt.query("select * from t_users", new RowMapper<Map<String, Object>>() {
//			@Override
//			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Map<String, Object> result = new HashMap<>();
//				result.put("id", rs.getInt("id"));
//				result.put("name", rs.getString("name"));
//				result.put("email", rs.getString("email"));
//				return result;
//			}
//		});
//		System.out.println("RowMapper结果："+query.toString());
		
		//测试RowCallbackHandler结果集回调
//		List<Map<String, Object>> query = new ArrayList<>();
//		jt.query("select * from t_users",new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				Map<String, Object> result = new HashMap<>();
//				result.put("id", rs.getInt("id"));
//				result.put("name", rs.getString("name"));
//				result.put("email", rs.getString("email"));
//				query.add(result);
//			}
//		});
//		System.out.println("RowCallbackHandler结果："+query.toString());
		
		//测试ResultSetExtractor结果集回调,必须手动处理整个结果集
		List<Map<String, Object>> query = jt.query("select * from t_users", new ResultSetExtractor<List<Map<String, Object>>>() {
			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, Object>> resultList = new ArrayList<>();
				while(rs.next()){
					Map<String, Object> result = new HashMap<>();
					result.put("id", rs.getInt("id"));
					result.put("name", rs.getString("name"));
					result.put("email", rs.getString("email"));
					resultList.add(result);
				}
				return resultList;
			}
		});
		System.out.println("ResultSetExtractor结果："+query.toString());

	}
	

/*******************************以下代码结合DAO、servers和注入进行实践测试***********************************************/
	
	/**
	 * 测试jdbcTemplate编程_查询
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbcTemplateQuery() {
		UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		List<Map<String, Object>> queryUser = userServiceImpl.queryUser();
		System.out.println("查询数据："+queryUser.toString());
	}
	/**
	 * 测试jdbcTemplate编程_添加
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
	 * 测试jdbcTemplate编程_删除
	 * @author SongZhangLiang
	 */
	@Test
	public void testJdbcTemplateDel() {
		UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl",UserServiceImpl.class);
		System.out.println("result:"+userServiceImpl.delUserById(1L));
	}

}
