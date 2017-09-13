package com.ccs.publish;

import javax.xml.ws.Endpoint;

import com.ccs.rest.AdagesProvider;

public class Publisher {

	public static void main(String[] args) {
		int port = 8888;
		String url = "http://localhost:" + port + "/";
		System.out.println("Restfully publishing on port " + port);
		Endpoint.publish(url, new AdagesProvider());
	}

}
