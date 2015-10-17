package com.pilaf.musicFactory.rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/file")
public class FileResource {

	public static final String UPLOADED_FILE_PARAMETER_NAME = "file";
	public static final String UPLOADED_FILES_PATH = "I:/in¿ynierski/uploadedFIles/";

	@Path("/upload")
	@POST
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm
				.get(UPLOADED_FILE_PARAMETER_NAME);

		for (InputPart inputPart : inputParts) {
			MultivaluedMap<String, String> headers = inputPart.getHeaders();
			try {
				InputStream inputStream = inputPart.getBody(InputStream.class,
						null);
				byte[] bytes = IOUtils.toByteArray(inputStream);
				String filename = getFileName(headers);
				FileOutputStream fos = new FileOutputStream(UPLOADED_FILES_PATH
						+ filename);
				fos.write(bytes);
				fos.close();
			} catch (IOException e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(e.getMessage()).build();
			}
		}
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces({ "image/png" })
	public Response getUserImage() throws IOException {
		String fileName = "IMG_0370.JPG";
		java.nio.file.Path path = java.nio.file.Paths.get(UPLOADED_FILES_PATH
				+ fileName);

		final byte[] image;
		image = Files.readAllBytes(path);
		// say your image is png?

		return Response.ok().entity(new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException,
					WebApplicationException {
				output.write(image);
				output.flush();
			}
		}).build();
	}

	private String getFileName(MultivaluedMap<String, String> headers) {
		String[] contentDisposition = headers.getFirst("Content-Disposition")
				.split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = sanitizeFilename(name[1]);
				return finalFileName;
			}
		}
		return "unknown";
	}

	private String sanitizeFilename(String s) {
		return s.trim().replaceAll("\"", "");
	}

}