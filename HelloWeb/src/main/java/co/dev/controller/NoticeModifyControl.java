package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;

public class NoticeModifyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String nid = req.getParameter("nid");
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		
		NoticeVO notice = new NoticeVO();
		notice.setNoticeId(Integer.parseInt(nid));
		notice.setNoticeTitle(title);
		notice.setNoticeSubject(subject);
		
		System.out.println(notice);
		
		//id기준으로 title,subject 변경
		//서비스 : noticeModify, mapper: updateNotice
		//목록페이지로 이동.
		
		NoticeService service = new NoticeServiceMybatis();
		boolean result = service.updateNotice(notice);
		System.out.println(result);
		
		if(result) {
			System.out.println("성공");
			req.setAttribute("message", "정상 처리 완료.");
			req.setAttribute("id",notice.getNoticeTitle());
			req.setAttribute("subject",notice.getNoticeSubject() );
		}else {
			System.out.println("예외.");
			req.setAttribute("message", "예외 발생");
		}//요청을 재지정해주는 객체 RequestDispatcher
		RequestDispatcher rd = //
				req.getRequestDispatcher("WEB-INF/notice/noticeList.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

		
	}

}
