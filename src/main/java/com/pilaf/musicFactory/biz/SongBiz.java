package com.pilaf.musicFactory.biz;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Song;

@Stateless
public class SongBiz extends BaseBiz<Song> {

	@Override
	protected String getDaoName() {
		return Song.class.getSimpleName() + "Dao";
	}

}
