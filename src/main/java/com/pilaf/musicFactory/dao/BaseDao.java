package com.pilaf.musicFactory.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao {
	
	@PersistenceContext(unitName="musicFactory")
	private EntityManager em;

	protected EntityManager getEm() {
		return em;
	}
	
	

}
