package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;

public class MemberDeleteControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		//MemberService, MemberDAO
		MemberService service = new MemberServiceImpl();
		
		if(service.removeMember(id)) {
				req.setAttribute("message", "정상 처리 완료."); 
			}else {
				req.setAttribute("message", "예외 발생");
			}
			//요청을 재지정해주는 객체 RequestDispatcher
					RequestDispatcher rd = //
					req.getRequestDispatcher("WEB-INF/member/memberDeleteOutput.jsp");
					try {
						rd.forward(req, resp);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
			
	}

}
