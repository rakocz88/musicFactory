package com.pilaf.musicFactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements MusicFactoryModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678093127003595593L;

	@Id
	@GeneratedValue
	long id;

	String login;

	@Column(name = "mpassword")
	String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
