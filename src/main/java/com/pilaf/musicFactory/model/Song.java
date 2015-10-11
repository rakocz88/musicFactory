package com.pilaf.musicFactory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song implements MusicFactoryModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private Band band;

	private Album album;

	private String songUrl;

	private Gengre gengre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public Gengre getGengre() {
		return gengre;
	}

	public void setGengre(Gengre gengre) {
		this.gengre = gengre;
	}

}
