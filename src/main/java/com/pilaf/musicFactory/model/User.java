package com.pilaf.musicFactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements MusicFactoryModel {

	public static final String USER_TABLE_NAME = "mf_user";
	public static final String ID_KEY = "id";
	public static final String LOGIN_KEY = "login";
	public static final String PASSWORD_KEY = "mf_password";
	private static final long serialVersionUID = -3678093127003595593L;

	@Id
	@GeneratedValue
	@Column(name = ID_KEY, nullable = false, unique = true)
	long id;

	@Column(name = LOGIN_KEY, nullable = false, unique = true)
	String login;

	@Column(name = PASSWORD_KEY, nullable = false, unique = false)
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
