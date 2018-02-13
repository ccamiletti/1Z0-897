package cl.ccs.ws;

import javax.jws.*;

@WebService(portName = "CustomerWSPort", serviceName = "CustomerWSService", targetNamespace = "http://cl.ccs.ws/", endpointInterface = "cl.ccs.ws.CustomerWS")
public class CustomerWSImpl implements CustomerWS {

	public String hello() {
		// replace with your impl here
		return "hi, you you entered correct credentials";

	}
}
