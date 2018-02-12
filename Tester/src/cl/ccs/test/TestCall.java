package cl.ccs.test;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import ws.ccs.cl.CustomerWS;

public class TestCall {

	
	private static final String WS_URL = "http://localhost:7001/1z0897WSAuth/CustomerWSService?WSDL";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCall tc = new TestCall();
		tc.callWSAth();
	}
	
	public void callWSAth() {
		
		try {
			
			URL url = new URL(WS_URL);
	        QName qname = new QName("http://cl.ccs.ws/", "CustomerWSService");

	        Service service = Service.create(url, qname);
	        CustomerWS hello = service.getPort(CustomerWS.class);

	        /*******************UserName & Password ******************************/
	        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
	        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
	        req_ctx.put(BindingProvider.USERNAME_PROPERTY, "1z0897User");
	        req_ctx.put(BindingProvider.PASSWORD_PROPERTY, "1z0897User");

//	        Map<String, List<String>> headers = new HashMap<String, List<String>>();
//	        headers.put("Username", Collections.singletonList("usertest"));
//	        headers.put("Password", Collections.singletonList("usertest111"));
//	        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
	        /**********************************************************************/
	        
	        System.out.println(hello.hello());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
