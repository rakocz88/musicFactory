package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.pilaf.musicFactory.model.User;


@Stateless
public class TestBiz {

	@PersistenceContext(unitName="musicFactory")
	private EntityManager em;
	
	
	public void doTest(User user){
		em.persist(user);
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		TypedQuery<User> querry = em.createQuery(cq);
		querry.getResultList();*/
		Query querry =em.createQuery("from User");
		querry.getResultList();
	}
	
	

}
