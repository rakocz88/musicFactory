package com.pilaf.musicFactory.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = Person.PERSON_TABLE_NAME)
public class Person implements MusicFactoryModel {

	public static final String PERSON_TABLE_NAME = "mf_person";
	public static final String ID_KEY = "id";
	public static final String FIRSTNAME_KEY = "first_name";
	public static final String LAST_NAME_KEY = "last_name";
	public static final String BIRTH_DATE_KEY = "birth_date";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = ID_KEY, nullable = false, unique = true)
	private long id;

	@Column(name = FIRSTNAME_KEY, nullable = false, unique = false)
	private String firstname;

	@Column(name = LAST_NAME_KEY, nullable = false, unique = false)
	private String lastname;

	@Column(name = BIRTH_DATE_KEY, nullable = true, unique = false)
	private Date birthDate;

	@ManyToMany(mappedBy = "personList")
	private List<Band> bandList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Band> getBandList() {
		return bandList;
	}

	public void setBandList(List<Band> bandList) {
		this.bandList = bandList;
	}

}
