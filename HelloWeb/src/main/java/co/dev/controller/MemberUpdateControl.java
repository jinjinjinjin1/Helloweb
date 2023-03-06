package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원정보 수정 : MemberService -> MemberDAO
		//parameter수정입력값-(id,name,pass,mail)
		String id= req.getParameter("id");
		String nm = req.getParameter("name");
		String pw = req.getParameter("password");
		String ml = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setName(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setMail(ml);
		System.out.println("입력: " + vo);
		
		//수정메소드 호출
		MemberService service = new MemberServiceImpl();
		boolean result = service.addMember(vo);
		System.out.println(result);
		
		if(result) {
			System.out.println("성공.");
			req.setAttribute("message", "정상 처리 완료."); 
			req.setAttribute("id", vo.getId());
		}else {
			System.out.println("예외.");
			req.setAttribute("message", "예외 발생");
		}
		//요청을 재지정해주는 객체 RequestDispatcher
				RequestDispatcher rd = //
						req.getRequestDispatcher("WEB-INF/member/memberUpdateOutput.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
		
		}
	}

