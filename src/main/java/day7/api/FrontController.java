package day7.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







@WebServlet(urlPatterns = {"/"},description = "모든 요청을 받는 서블릿")
public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		RequestControllerMapping.init();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		String method = request.getMethod();
		
		RequestMap map = new RequestMap(url, method);
		Controller controller =RequestControllerMapping.getController(map);
			controller.handle(request, response);

	}
}