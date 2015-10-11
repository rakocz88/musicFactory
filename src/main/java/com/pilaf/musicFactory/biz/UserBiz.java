package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.User;

@Stateless
public class UserBiz extends BaseBiz<User> {

	@Override
	protected String getDaoName() {
		return User.class.getSimpleName() + "Dao";
	}

}
