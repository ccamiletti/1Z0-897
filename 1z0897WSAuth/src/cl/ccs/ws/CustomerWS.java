package cl.ccs.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "CustomerWS", targetNamespace = "http://cl.ccs.ws/")
public interface CustomerWS {

	@WebMethod(operationName = "hello")
	public String hello();
}