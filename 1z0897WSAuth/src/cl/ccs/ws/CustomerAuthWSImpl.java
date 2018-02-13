package cl.ccs.ws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(portName = "CustomerAuthWSPort", serviceName = "CustomerAuthWSService", targetNamespace = "http://cl.ccs.ws/", endpointInterface = "cl.ccs.ws.CustomerAuthWS")
public class CustomerAuthWSImpl implements CustomerAuthWS {

    @Resource
    private WebServiceContext context;
	
	public String hello() {
		// replace with your impl here
		
		MessageContext mc = context.getMessageContext();
		ServletContext servletContext = (ServletContext) mc.get(MessageContext.SERVLET_CONTEXT);
		
		return "hi, i am a webservice with authentications...";

	}

	public String bye(String name) {
		return "good bye " + name;
	}
	
	
}
