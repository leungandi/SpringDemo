package com.szl.springjdbc.service;

import java.util.List;
import java.util.Map;

import com.szl.springjdbc.entity.User;

public interface UserService {
	
	int addUser(User user);
	
	List<Map<String, Object>> queryUser();
	
	int delUserById(Long id);

}
