package com.pilaf.musicFactory.biz;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.pilaf.musicFactory.dao.BaseDao;
import com.pilaf.musicFactory.model.MusicFactoryModel;

public abstract class BaseBiz<T extends MusicFactoryModel> {

	private BaseDao<T> baseDao;

	public void create(T t) {
		getDaoBean().create(t);
	}

	public void update(T t) {
		getDaoBean().update(t);
	}

	public void remove(T t) {
		getDaoBean().remove(t);
	}

	protected BaseDao<T> getDaoBean() {
		if (baseDao == null) {
			InitialContext ic;
			try {
				ic = new InitialContext();
				baseDao = (BaseDao<T>) ic.lookup("java:module/" + getDaoName());
			} catch (NamingException e) {
				e.printStackTrace();
				throw new RuntimeException("JNDI ERROR-getDaoBean()"
						+ e.getMessage());
			}

		}
		return baseDao;
	}

	protected abstract String getDaoName();
}
