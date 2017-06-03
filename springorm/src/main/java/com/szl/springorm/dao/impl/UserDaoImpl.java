package com.szl.springorm.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.szl.springorm.dao.UserDao;
import com.szl.springorm.model.User;

/**
 * 
 * SqlSessionDaoSupport 是 一 个 抽象 的支 持 类, 提供 SqlSession.
 * 调 用 getSqlSession()方法你会得到一个 SqlSessionTemplate,之后可以用于执行 SQL 方法
 * 
 * 使用SqlSessionDaoSupport的方法，需要编写DAO的实现类
 * @author SongZhangLiang
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public int addUser(User user) {
		return this.getSqlSession().insert("com.szl.springorm.dao.UserDao.addUser", user);
	}

	@Override
	public List<Map<String, Object>> queryUser() {
		return this.getSqlSession().selectList("com.szl.springorm.dao.UserDao.queryUser");
	}

	@Override
	public int delUserById(Long id) {
		return this.getSqlSession().delete("com.szl.springorm.dao.UserDao.delUserById",id);
	}

}
