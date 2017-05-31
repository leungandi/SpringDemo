package com.szl.springjdbc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import com.szl.springjdbc.dao.UserDao;
import com.szl.springjdbc.entity.User;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addUser(User user) {
		return jdbcTemplate.update("INSERT INTO t_users(name,email)VALUES(?,?)", user.getName(),user.getEmail());
	}

	@Override
	public List<Map<String, Object>> queryUser() {
		return jdbcTemplate.queryForList("SELECT * FROM t_users");
	}

	@Override
	public int delUserById(Long id) {
		return jdbcTemplate.update("delete from t_users where id=?",id);
	}

}
