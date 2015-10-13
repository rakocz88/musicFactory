package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Album;

@Stateless
public class AlbumBiz extends BaseBiz<Album> {

	@Override
	protected String getDaoName() {
		return Album.class.getSimpleName() + "Dao";
	}

}
