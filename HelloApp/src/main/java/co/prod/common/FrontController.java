package co.prod.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.MemberListControl;
import co.prod.controller.MembersControl;

public class FrontController extends HttpServlet{
	
	private Map<String , Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	 // url <-> control
	map.put("/memberList.do", new MemberListControl());
	map.put("/members.do", new MembersControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //주소 넘어옴 localhost:8081
		System.out.println(uri);
		String context = req.getContextPath(); //프로젝트 이름 넘어옴 -> HelloApp
		System.out.println(context);
		String page = uri.substring(context.length());
		System.out.println("do page: " + page);
		
		Control command = map.get(page);
		String viewPage = command.exec(req,resp);
		
		if(viewPage.endsWith(".jsp")){
			viewPage = "./" + viewPage;
	//	}else if (viewPage.endsWith("tiles")) {
		}
		
		//req.getRequestDispatcher(viewPage);
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
	
}
