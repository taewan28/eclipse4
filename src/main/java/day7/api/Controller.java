package day7.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//개발자 정의 - 인자를 sevice, doGet , doPost 와 동일한 형식으로 정의
	void handle(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException ;
}
