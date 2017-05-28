package com.szl.springaop.service.impl;

import com.szl.springaop.dao.UserDao;
import com.szl.springaop.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 模拟向数据库插入用户数据
	 */
	@Override
	public void insetUser() {
		//测试后置异常通知，必须要抛异常
//		int i = 1/0;
		userDao.insertUser();
	}
	
	
	/**
	 * 模拟向数据库查询
	 */
	@Override
	public String queryUser() {
		return userDao.queryUser();
	}

}
