package day7.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dto.CustomerDto;
import lombok.extern.java.Log;


public class ApiCustomerGetController implements Controller {
   public static final Logger logger = LoggerFactory.getLogger(ApiCustomerGetController.class);
   @Override
   public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // TODO Auto-generated method stub
      MybatisCustomerDao dao = new MybatisCustomerDao();
      CustomerDto dto = dao.getCustomer(req.getParameter("id"));
      logger.info("getCustomer dto : {}",dto);
      
      // (List) 자바 객체를 json 문자열로 변환
      // 아이디 중복검사가 아닌 고객 조회이면 사용하기
      /*ObjectMapper objectMapper = new ObjectMapper();
      String jsonData = null;
      jsonData = objectMapper.writeValueAsString(dto);
      objectMapper.writeValueAsString(jsonData);
      logger.info("전송할 json 문자열 : {}",jsonData);*/
      
      int result=0;
      if(dto!=null) result=1;
      //2) 아이디 중복검사인 경우에는 json 으로 있다 또는 없다에 대한 값으로 전달하기
      String jsonData = "{ \"result\" : "+result+" }";
      resp.setContentType("application/json; charset=UTF-8");
      resp.getWriter().print(jsonData);

      
      
      // logger.info("전송할 json 문자열 : {}", jsonData);
//      System.out.println(jsonData);
//      resp.setContentType("application/json; charset=UTF-8");
//      PrintWriter out = resp.getWriter();
//      out.print(jsonData);
   }

}