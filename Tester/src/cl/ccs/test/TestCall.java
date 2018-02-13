package cl.ccs.test;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import ws.ccs.cl.CustomerAuthWS;
import ws.ccs.cl.CustomerAuthWSService;
import ws.ccs.com.CustomerWS;
import ws.ccs.com.CustomerWSService;

public class TestCall {

	
	private static final String WS_URLAUTH = "http://170.1.1.119:7001/1z0897WSAuth/CustomerAuthWSService?WSDL";
	private static final String WS_URL = "http://170.1.1.119:7001/1z0897WS/CustomerWSService?WSDL";
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCall tc = new TestCall();
		tc.callWS();
		tc.callWSAth();
	}
	
	public void callWSAth() {
		
		try {
			
			URL url = new URL(WS_URLAUTH);
	        QName qname = new QName("http://cl.ccs.ws/", "CustomerAuthWSService");

	        CustomerAuthWSService service = new CustomerAuthWSService(url, qname);
	        CustomerAuthWS hello = service.getPort(CustomerAuthWS.class);

	        /*******************UserName & Password ******************************/
	        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
	        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URLAUTH);
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

	public void callWS() {
		
		try {
			
			URL url = new URL(WS_URL);
	        QName qname = new QName("http://com.ccs.ws/", "CustomerWSService");

	        CustomerWSService service = new CustomerWSService(url, qname);
	        CustomerWS hello = service.getPort(CustomerWS.class);

	        System.out.println(hello.hello("carlo"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
