package com.pilaf.musicFactory.rest.registration;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pilaf.musicFactory.dao.BandDao;
import com.pilaf.musicFactory.dao.PersonDao;
import com.pilaf.musicFactory.dao.UserDao;
import com.pilaf.musicFactory.model.Band;
import com.pilaf.musicFactory.model.Person;
import com.pilaf.musicFactory.model.User;
import com.pilaf.musicFactory.model.json.NewRegisteredPersonWithBand;
import com.pilaf.musicFactory.model.json.NewRegisteredUserJson;

@Path("/register")
public class RegisterRest {

	@Inject
	private UserDao userDao;

	@Inject
	private PersonDao personDao;

	@Inject
	private BandDao bandDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(NewRegisteredUserJson userJson) {
		User user = new User(userJson);
		Person person = new Person(userJson);
		userDao.create(user);
		personDao.create(person);
		return Response.status(200).build();
	}

	@POST
	@Path(value = "/registerWithBand")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserWithBand(
			NewRegisteredPersonWithBand personWithBand) {
		User user = new User(personWithBand);
		Person person = new Person(personWithBand);
		Band band = new Band(personWithBand);
		userDao.create(user);
		personDao.create(person);
		bandDao.create(band);
		return Response.status(200).build();
	}

}
