package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Band;

@Stateless
public class BandBiz extends BaseBiz<Band> {

	@Override
	protected String getDaoName() {
		return Band.class.getSimpleName() + "Dao";
	}

}
