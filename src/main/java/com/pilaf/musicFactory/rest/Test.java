package com.pilaf.musicFactory.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.pilaf.musicFactory.biz.TestBiz;
import com.pilaf.musicFactory.model.User;

@Path("/music")
public class Test {
	
	@Inject
	private TestBiz testBIz;
	
	@GET
	@Path("/helloworld")
	public Response getHelloWorld() {
		User user = new User();
		user.setLogin("Buba");
		user.setPassword("Wal");
		
		
		
		
		String value = "Hello World";
		testBIz.doTest(user);
		
		
		return Response.status(200).entity(value).build();
	}

}
