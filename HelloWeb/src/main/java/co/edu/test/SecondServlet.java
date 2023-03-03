package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	//@WebServlet 어노테이션을 활용
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();//클라이언트 출력 스트림 생성.
		//출력 스트림은 기본적으론 text/plain,encode=8859_1 기본.
		out.print("<h3>좋은 하루 되세요!</h3>");
		out.close();
		
	}
	
	
	
}
