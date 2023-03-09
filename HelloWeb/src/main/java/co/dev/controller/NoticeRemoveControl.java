package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;

public class NoticeRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int nid = Integer.parseInt(req.getParameter("nid"));
		
		 //FrontController에 NoticeRemoveControl();
		 //서비스:noticeRemove(int nid), mapper: deleteNotice(int nid)
		
		NoticeService service = new NoticeServiceMybatis();
		
		if(service.deleteNotice(nid)){
			System.out.println("삭제 완료");
			req.setAttribute("message","정상 처리 완료." );
		}else {
			System.out.println("삭제 실패");
			req.setAttribute("message", "예외 발생");
		}
		//요청을 재지정해주는 객체 RequestDispatcher
		req.getRequestDispatcher(null);
	}

}
