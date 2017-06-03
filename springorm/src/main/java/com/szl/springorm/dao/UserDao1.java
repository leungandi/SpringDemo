package com.szl.springorm.dao;

import java.util.List;
import java.util.Map;

import com.szl.springorm.model.User;



public interface UserDao1 {
	/**
	 * 增加用户
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 查询用户
	 * @return
	 */
	List<Map<String, Object>> queryUser();
	
	/**
	 * 删除用户
	 * @return
	 */
	int delUserById(Long id);

}
