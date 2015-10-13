package com.pilaf.musicFactory.rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/file")
public class FileResource {

	public static final String UPLOADED_FILE_PARAMETER_NAME = "file";

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
				FileOutputStream fos = new FileOutputStream(filename);
				fos.write(bytes);
				fos.close();
				// TODO: HERE you do whatever you want to do with the file
				// ...
			} catch (IOException e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(e.getMessage()).build();
			}
		}
		return Response.status(Response.Status.OK).build();
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