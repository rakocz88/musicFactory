package com.pilaf.musicFactory.dao;

import javax.ejb.Stateless;

import com.pilaf.musicFactory.model.Album;

@Stateless(name = "AlbumDao")
public class AlbumDao extends BaseDao<Album> {

	private static final long serialVersionUID = 1L;

}
