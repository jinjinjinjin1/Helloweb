package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServ extends HttpServlet {
	//필드
	String enc; 
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		super.init(config); //init 메소드에서 Context값을 지정.
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc); //없으면 요청 정보 -> 한글처리를 못함.
		System.out.println(enc);
		
		//ServletContext는 어플리케이션에 생성되는 객체.
		ServletContext sc = this.getServletContext(); //객체에 소속된 메소드.
		System.out.println("sc: " + sc);
		String param = sc.getInitParameter("contextConfig");
		System.out.println("param: " + param);
		
		//공유된 값을 불러오기.
		System.out.println("공유된 param" + sc.getAttribute("param"));
		
		
		resp.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out= resp.getWriter();
		
		out.print("이름:" + req.getParameter("name"));
		out.close();
		
	}

	
	
}
