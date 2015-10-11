package com.pilaf.musicFactory.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.pilaf.musicFactory.biz.UserBiz;
import com.pilaf.musicFactory.model.User;

@Path("/music")
public class UserRest {

	@Inject
	private UserBiz testBIz;

	@GET
	@Path("/helloworld")
	public Response getHelloWorld() {
		User user = new User();
		user.setLogin("Buba3");
		user.setPassword("Wal");
		String value = "Hello World";
		testBIz.create(user);

		return Response.status(200).entity(value).build();
	}

}
