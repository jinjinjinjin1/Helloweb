package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/headerInfo","/headInfo"}) //실행할 파일패턴

public class HeaderInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String html = "<html><head><title> header 정보 </title></head>";
		html += "<body>";
		html += "<h3>요청헤더정보</h3>";
		
		
		
		Enumeration<String> em = req.getHeaderNames();//헤더정보 전체 가지고 오기.
		
		while(em.hasMoreElements()) {
			String head = em.nextElement();
			html += head + " : " + req.getHeader(head)+ "<br>";
		}
		html += "</body></html>";
		
		
		out.print(html);
		out.close();
		//super.service(req, resp);
	}

	
}
