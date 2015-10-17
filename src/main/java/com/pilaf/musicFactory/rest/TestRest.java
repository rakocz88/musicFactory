package com.pilaf.musicFactory.rest;

import java.lang.reflect.Field;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.pilaf.musicFactory.annotation.Describe;
import com.pilaf.musicFactory.model.Person;

@Path("/test")
public class TestRest {

	@GET
	public Response getHelloWorld() {
		Class<Person> perClass = Person.class;
		Field[] fields = perClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Describe.class)) {
				field.setAccessible(true);
				Describe desc = field.getAnnotation(Describe.class);
				System.out.println("Jest annotacja");
				if (desc.enabled() == true) {
					System.out.println("I jeszcze jest true");
					System.out.println(" A wartoœæ to " + desc.createdBy());
				}
				System.out.println();
			}
		}

		return Response.status(200).entity("").build();
	}

}
