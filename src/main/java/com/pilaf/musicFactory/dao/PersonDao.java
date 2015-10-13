package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Person;

@Stateless(name = "PersonDao")
public class PersonDao extends BaseDao<Person> {

	private static final long serialVersionUID = 1L;

}
