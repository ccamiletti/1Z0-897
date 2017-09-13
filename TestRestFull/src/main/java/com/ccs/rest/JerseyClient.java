package com.ccs.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.representation.Form;

public class JerseyClient {

	private static final String baseUrl = "http://localhost:8081/TestRestFull/rest/admin/createClient/";

	public static void main(String[] args) {
		new JerseyClient().demo();
	}

	private void demo() {
		Client client = Client.create();
		client.setFollowRedirects(true); // in case the service redirects
		WebResource resource = client.resource(baseUrl);
		//getAllDemo(resource);
		com.ccs.commun.Client c = new com.ccs.commun.Client();
		c.setAddress("");
		c.setAge("23");
		c.setDni(1111111);
		c.setName("test jerseyClient");
		postDemo(resource, c); // same resource but different verb
		String url = baseUrl + "?id=32";
		resource = client.resource(url);
		getOneDemo(resource);
		deleteDemo(resource); // delete id = 32
	}

	private void getAllDemo(WebResource resource) {
		// GET all XML
		String response = resource.accept(MediaType.APPLICATION_XML_TYPE).get(
				String.class);
		report("GET all in XML:\n", response);
		// GET all JSON
		response = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				String.class);
		report("GET all in JSON:\n", response);
	}

	private void getOneDemo(WebResource resource) {
		String response = resource.accept(MediaType.APPLICATION_XML_TYPE).get(
				String.class);
		report("GET one in XML:\n", response);
		response = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				String.class);
		report("GET one in JSON:\n", response);
	}

	private void postDemo(WebResource resource, com.ccs.commun.Client cStr) {
		try {

			String input = "{\"name\":\"testClinet\",\"address\":\"my address\",\"dni\":\"3232342\"}";
			//String input = "{\"name\": null\", address: \"null\", age: \"null\", phone: \"null\", dni: \"null\"}";

			ClientResponse response = resource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }	}

	private void deleteDemo(WebResource resource) {
		String response = resource.accept(MediaType.TEXT_PLAIN_TYPE).delete(
				String.class);
		report("DELETE:\n", response);
	}

	private void report(String msg, String response) {
		System.out.println("\n" + msg + response);
	}
}
