package day7.api;

import java.util.HashMap;
import java.util.Map;



public class RequestControllerMapping {
	
	// key는 url, method로 구성된 RequestMap 객체, value는 Controller
	
	private static final Map<RequestMap,Controller> mapping = new HashMap<>();
	public static void init() {
		mapping.put(new RequestMap("/api/customer/list", "GET"), new ApiCustomerListController());
		mapping.put(new RequestMap("/api/customer", "POST"), new ApiCustomerPostController());
		mapping.put(new RequestMap("/api/customer", "GET"), new ApiCustomerGetController());
		mapping.put(new RequestMap("/api/product/list", "GET"), new ApiProductListController());
		mapping.put(new RequestMap("/api/product", "POST"), new ApiProductPostController());
	}
	
	public static Controller getController(RequestMap key) {
		return mapping.get(key);	// value에 해당하는 Controller 객체 리턴
	}
}





















