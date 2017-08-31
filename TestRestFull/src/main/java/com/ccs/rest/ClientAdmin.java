package com.ccs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ccs.commun.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/admin")
public class ClientAdmin {

	
	public static List<Client> clientList = new ArrayList<Client>();
	public ClientAdmin() {
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response createClient(@PathParam("id") String id, Client cParam) {
		
		Response rb = null;
		
		try {
			boolean resp = clientList.remove(findClient(id));
			if (resp) {
				clientList.add(cParam);
				rb = Response.ok(toJson(cParam), "application/json").build();
			}else {
				rb = Response.ok(Response.Status.ACCEPTED).entity("The Client does not exist").type(MediaType.TEXT_PLAIN).build();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createClient")
	public String insertClient(Client c) {
		
		clientList.add(c);
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(c);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/clientList")
	public String getXMLClients() {
		String xml = null;
		try {
		    xml = toJson(clientList);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return xml;
	}
	
	@GET
	@Path("/cleanList")
	public void dropData() {
		clientList.clear();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findClient")
	public Client findClient(@FormParam("id") String id) {
		Client resp = null;
		if (null != id) {
			for (Client c : clientList) {
				if (c.getName().equals(id)) {
					resp = c;
				}
			}
		}
		return resp;
	}
	
	@DELETE
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/deleteClient/{dni: \\d+}")
	public Response deleteClient(@PathParam("dni") Integer dni) {
		Response rb = null;
		try {
			Client resp = null;
			for (Client c : clientList) {
				if (c.getDni().equals(dni)) {
					resp = c;
				}
			}
			if (null == resp)
				throw new Exception();
			
			clientList.remove(resp);
			rb = Response.status(Response.Status.OK).entity("").type(MediaType.TEXT_PLAIN).build();
		}catch(Exception e) {
			rb = Response.status(Response.Status.BAD_REQUEST).entity("ERROR").type(MediaType.TEXT_PLAIN).build();
		}
		
		return rb;
		
	}
	
	private String toJson(Object c) throws Exception {
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(c);
		} catch (Exception e) {
			throw e;
		}
		return json;
	}
	
	
	
}
