package day7.api;

import java.util.HashMap;
import java.util.Map;


public class RequestControllerMapping {
	
	private static final Map<RequestMap, Controller> mapping = new HashMap<>();
	
	public static void init() {
		mapping.put(new RequestMap("/api/customer/list","GET"), new ApiCustomerListController());
		mapping.put(new RequestMap("/api/product/list","GET"), new ApiProductListController());

	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key);	
	}
}
