package com.pilaf.musicFactory.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Band.BAND_TABLE_NAME)
public class Band implements MusicFactoryModel {
	private static final long serialVersionUID = 1L;

	public static final String BAND_TABLE_NAME = "mf_band";
	public static final String ID_KEY = "id";
	public static final String NAME_KEY = "name";
	public static final String GENGRE_KEY = "gengre";
	public static final String INIT_DATE_KEY = "init_date";

	public static final String PERSON_BAND_TABLE = "mf_per_band";
	public static final String PERSON_JOIN_KEY = "person_id";
	public static final String BAND_JOIN_KEY = "band_id";
	public static final String ALBUMS_KEY = "album_List";

	@Id
	@GeneratedValue
	@Column(name = ID_KEY, nullable = false, unique = true)
	private long id;

	@Column(name = NAME_KEY, nullable = false, unique = true)
	private String name;

	@Column(name = GENGRE_KEY, nullable = true, unique = false)
	private Gengre gengre;

	@Column(name = INIT_DATE_KEY, nullable = true, unique = false)
	private Date initDate;

	@ManyToMany
	@JoinTable(name = PERSON_BAND_TABLE, joinColumns = { @JoinColumn(name = PERSON_JOIN_KEY) }, inverseJoinColumns = { @JoinColumn(name = BAND_JOIN_KEY) })
	private List<Person> personList;

	@OneToMany
	@JoinColumn(name = ALBUMS_KEY, nullable = true)
	private List<Album> albumList;

	// ==========GETTERS AND SETTERS
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

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

}
