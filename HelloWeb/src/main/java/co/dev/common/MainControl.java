package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {
	//main.do (url)
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println("main");
		
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/main/main.jsp");
		//RequestDispatcher rd = req.getRequestDispatcher("member/member.jsp");
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} // 페이지 재지정. 
	}

}
