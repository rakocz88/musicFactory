package com.pilaf.musicFactory.dao;

import com.pilaf.musicFactory.model.User;

public class UserDao extends BaseDao{
	
	
	public void createUser(User user){
		 getEm().persist(user);
	}

}
