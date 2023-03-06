package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberInsertFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//회원등록화면 호출.
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/member/memberInsert.jsp"); //열어줄 화면
		//forwarding처리
		try {
			rd.forward(req, resp); //요청재지정.
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
