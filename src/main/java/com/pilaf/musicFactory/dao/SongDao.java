package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Song;

@Stateless(name = "SongDao")
public class SongDao extends BaseDao<Song> {

	private static final long serialVersionUID = 1L;

}
