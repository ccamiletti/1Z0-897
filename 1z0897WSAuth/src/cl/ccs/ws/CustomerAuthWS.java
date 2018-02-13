package cl.ccs.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "CustomerAuthWS", targetNamespace = "http://cl.ccs.ws/")
public interface CustomerAuthWS {

	@WebMethod(operationName = "hello")
	public String hello();

	@WebMethod(operationName = "bye")
	public String bye(String name);
}