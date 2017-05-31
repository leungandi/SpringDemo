package com.szl.springjdbc.service.impl;

import java.util.List;
import java.util.Map;

import com.szl.springjdbc.dao.UserDao;
import com.szl.springjdbc.entity.User;
import com.szl.springjdbc.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;	
	
	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<Map<String, Object>> queryUser() {
		return userDao.queryUser();
	}

	@Override
	public int delUserById(Long id) {
		return userDao. delUserById(id);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
