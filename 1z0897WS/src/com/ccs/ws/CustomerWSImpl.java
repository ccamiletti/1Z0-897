package com.ccs.ws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(portName = "CustomerWSPort", serviceName = "CustomerWSService",	targetNamespace = "http://com.ccs.ws/", endpointInterface = "com.ccs.ws.CustomerWS")
public class CustomerWSImpl implements CustomerWS {

	@Resource
	private WebServiceContext context;
	
	public String getName(String user) {

		MessageContext mc = context.getMessageContext();
        ServletContext servletContext = (ServletContext) mc.get(MessageContext.SERVLET_CONTEXT);

		
		return "Hi " + user + " i am a WebService";

	}
	
	
	
}
