package com.szl.springorm.service.impl;

import java.util.List;
import java.util.Map;


import com.szl.springorm.dao.UserDao1;
import com.szl.springorm.model.User;
import com.szl.springorm.service.UserService;

public class UserServiceImpl implements UserService {
	

	private UserDao1 userDao1;
	

	public void setUserDao1(UserDao1 userDao1) {
		this.userDao1 = userDao1;
	}

	@Override
	public int addUser(User user) {
		return userDao1.addUser(user);
	}

	@Override
	public List<Map<String, Object>> queryUser() {
		return userDao1.queryUser();
	}

	@Override
	public int delUserById(Long id) {
		return userDao1.delUserById(id);
	}
	
	

}
