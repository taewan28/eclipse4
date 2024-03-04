package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j

public class ApiProductPostController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		// 사용자가 보낸 데이터는 json 문자열 입니다. 이 데이터를 읽어오기 위해 입력스트림이 필요합니다.
		InputStream inputStream = req.getInputStream();		// http 전송방식의 입력스트림 생성. 요청 객체로 만들어집니다.
		
		// 입출력의 속도 향상을 위해 버퍼를 사용합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		
		StringBuffer sb = new StringBuffer();	// String은 불변 객체이므로 + 연결연산을 대신하는 메소드를 사용하기 위해 필요
		String line = null;
		
		while((line = br.readLine()) != null) {	// 입력 스트림으로 부터 1줄씩 읽어 옵니다.
			sb.append(line);
			log.info("line : {}", line);
		}
		
		// json 문자열을 자바객체로 변환합니다.
		ObjectMapper objectMapper = new ObjectMapper();
		ProductDto dto = objectMapper.readValue(sb.toString(), ProductDto.class);
		
		log.info("변환된 dto : {}", dto);
		
		// dao insert
		int result = 0;
		try {
			MybatisProductDao dao = new MybatisProductDao();
			result = dao.insert(dto);
		}catch (Exception e) {
			log.info("dao insert 예외 : {}", e.getMessage());
		}
		// insert 결과에 대한 응답을 보내기
		// 방법1 : 순수한 문자열을 응답으로 보내기
		/*
		   String msg = "회원등록이 완료되었습니다.";
		   if(result == 0) msg = "회원등록 오류 입니다. id 중복 확인하세요.";
	       resp.setContentType("text/plain; charset=UTF-8");
		   resp.getWriter().print(msg);
		 */
		
		
		// 방법2 : json 문자열로 result 결과값 보내기
		String jsonData = "{ \"result\" : "+result+" }";
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(jsonData);
		
	}

}
