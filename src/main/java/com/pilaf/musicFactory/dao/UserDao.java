package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.User;

@Stateless(name = "UserDao")
public class UserDao extends BaseDao<User> {

	private static final long serialVersionUID = 1L;

}
