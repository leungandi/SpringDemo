package com.szl.springaop.dao.impl;

import com.szl.springaop.dao.UserDao;

public class UserDaoImpl implements UserDao{

	/**
	 * 模拟向数据库插入用户信息
	 */
	@Override
	public void insertUser() {
		System.out.println("向数组库插入用户信息");
	}

	@Override
	public String queryUser() {
		return "你好，世界";
	}
	


}
