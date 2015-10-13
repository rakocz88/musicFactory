package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Person;

@Stateless
public class PersonBiz extends BaseBiz<Person> {

	@Override
	protected String getDaoName() {
		return Person.class.getSimpleName() + "Dao";
	}

}
