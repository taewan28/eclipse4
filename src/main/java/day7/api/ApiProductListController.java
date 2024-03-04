package day7.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public class ApiProductListController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.Allselect();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = null;
		jsonData = objectMapper.writeValueAsString(list);
		objectMapper.writeValueAsString(list);
		
		System.out.println(jsonData);
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(jsonData);

	}

}
