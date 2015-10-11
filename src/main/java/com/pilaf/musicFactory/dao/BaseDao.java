package com.pilaf.musicFactory.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pilaf.musicFactory.model.MusicFactoryModel;

public abstract class BaseDao<T extends MusicFactoryModel> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "musicFactory")
	private EntityManager em;

	protected EntityManager getEm() {
		return em;
	}

	public void create(T t) {
		em.persist(t);
	}

	public void update(T t) {
		em.merge(t);
	}

	public void remove(T t) {
		em.remove(t);
	}

}
