package com.pilaf.musicFactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Song.SONG_TABLE_NAME)
public class Song implements MusicFactoryModel {

	public static final String SONG_TABLE_NAME = "mf_song";
	public static final String ID_KEY = "id";
	public static final String BAND_JOIN_KEY = "band_id";
	public static final String ALBUM_JOIN_KEY = "album_id";
	public static final String SONG_URL_KEY = "song_url";
	public static final String GENGRE_KEY = "gengre";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = ID_KEY, nullable = false, unique = true)
	private long id;

	@ManyToOne
	@JoinColumn(name = BAND_JOIN_KEY, nullable = true, unique = false)
	private Band band;

	@ManyToOne
	@JoinColumn(name = ALBUM_JOIN_KEY, nullable = false, unique = true)
	private Album album;

	@Column(name = SONG_URL_KEY, nullable = false, unique = true)
	private String songUrl;

	@Column(name = GENGRE_KEY, nullable = false, unique = true)
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
