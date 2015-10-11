package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.User;

@Stateless
public class UserDao extends BaseDao {

	public void createUser(User user) {
		getEm().persist(user);
	}

}
