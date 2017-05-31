package com.szl.springjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcUtil {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String password = "123456";
	
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet executeQuery;
	
	public void JdbcTest(){
		try {
			//加载驱动
			Class.forName(driver);
			//获取连接且开启事务
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			//预编译sql
			prepareStatement = connection.prepareStatement("select * from t_users");
			//执行sql
			ResultSet executeQuery = prepareStatement.executeQuery();
			int colNum = executeQuery.getMetaData().getColumnCount();
			//处理结果集
			while(executeQuery.next()){
				for(int i=0; i<colNum; i++){
					System.out.println(executeQuery.getString(i+1));
				}
				System.out.println("-----------------------------");
			}
			//提交事务
			connection.commit();
		} catch (ClassNotFoundException e) {
			try {
				//异常事务回滚
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			//关闭连接
			try {
				if(null != executeQuery)
					executeQuery.close();
				if(null != prepareStatement)
					prepareStatement.close();
				if(null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
