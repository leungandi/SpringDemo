package com.szl.springjdbc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.szl.springjdbc.dao.UserDao;
import com.szl.springjdbc.entity.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Override
	public int addUser(User user) {
		
		return getJdbcTemplate().update("INSERT INTO t_users(name,email)VALUES(?,?)", user.getName(),user.getEmail());
	}

	@Override
	public List<Map<String, Object>> queryUser() {
		return getJdbcTemplate().queryForList("SELECT * FROM t_users");
	}

	@Override
	public int delUserById(Long id) {
		return getJdbcTemplate().update("delete from t_users where id=?",id);
	}

}
