package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pilaf.musicFactory.dao.UserDao;
import com.pilaf.musicFactory.model.User;

@Stateless
public class UserBiz {

	@PersistenceContext(unitName = "musicFactory")
	private EntityManager em;

	@Inject
	private UserDao userDao;

	public void createUser(User user) {
		userDao.createUser(user);
	}

}
