package com.ccs.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "CustomerWS", targetNamespace = "http://com.ccs.ws/")
public interface CustomerWS {

	@WebMethod(operationName = "hello")
	public String getName(String user);
	
}