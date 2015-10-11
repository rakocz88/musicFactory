package com.pilaf.musicFactory.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person implements MusicFactoryModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private String firstname;

	private String lastname;

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
