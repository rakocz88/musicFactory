package com.pilaf.musicFactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Album.ALBUM_KEY)
public class Album implements MusicFactoryModel {

	public static final String ID_KEY = "id";
	public static final String NAME_KEY = "name";
	public static final String SONG_AMOUNT_KEY = "songAmount";
	public static final String ALBUM_KEY = "mf_album";
	public static final String BAND_ID_KEY = "band_id";
	public static final String GENGRE_KEY = "gengre";
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = ID_KEY, nullable = false, unique = true)
	private long id;

	@Column(name = NAME_KEY, nullable = false, unique = true, length = 100)
	private String name;

	@Column(name = GENGRE_KEY, nullable = true, unique = false)
	private Gengre gengre;

	@Column(name = SONG_AMOUNT_KEY, nullable = true, unique = false)
	private int songAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = BAND_ID_KEY)
	@Column(nullable = false, unique = false)
	private Band band;

	// GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gengre getGengre() {
		return gengre;
	}

	public void setGengre(Gengre gengre) {
		this.gengre = gengre;
	}

	public int getSongAmount() {
		return songAmount;
	}

	public void setSongAmount(int songAmount) {
		this.songAmount = songAmount;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

}
