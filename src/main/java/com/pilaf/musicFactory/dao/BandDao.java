package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Band;

@Stateless(name = "BandDao")
public class BandDao extends BaseDao<Band> {

	private static final long serialVersionUID = 1L;

}
