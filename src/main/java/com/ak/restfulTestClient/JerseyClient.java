package com.ak.restfulTestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	private static final String BASE_ADDRESS = "http://localhost:8080/centric/webapi/";

	public static void postClient(String param) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(BASE_ADDRESS+"insert/");
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, param);
			if (response.getStatus() != 200) 
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			System.out.println("Server response - " + response.getStatus() + "\n"
					+ response.getEntity(String.class));
		} catch (Exception e) { e.printStackTrace(); }
	}

	public static void main(String[] args) {
		String param = "{"
				+ "\"brand\":\"Hugo Boss\","
				+ "\"category\":\"apparel\","
				+ "\"description\":\"Red hugo boss shirt\","
				+ "\"name\":\"Red Shirt\","
				+ "\"tags\":["
				+ "\"red\",\"shirt\",\"slim fit\"]"
				+ "}";
		postClient(param);
	}

}
