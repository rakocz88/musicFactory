package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.pilaf.musicFactory.dao.UserDao;
import com.pilaf.musicFactory.model.User;

@Stateless
public class UserBiz extends BaseBiz {

	@Inject
	private UserDao userDao;

	public void createUser(User user) {
		userDao.createUser(user);

	}

}
