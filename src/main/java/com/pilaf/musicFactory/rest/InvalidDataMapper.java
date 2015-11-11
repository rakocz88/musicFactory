package com.pilaf.musicFactory.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pilaf.musicFactory.exception.MFException;

@Provider
public class InvalidDataMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception arg0) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(new MFException("key", arg0.getMessage())).build();
	}

}