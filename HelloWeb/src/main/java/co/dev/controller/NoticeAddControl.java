package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;

public class NoticeAddControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//첨부파일: 서버의 특정위치에 업로드. cos.jar 라는 라이브러리 사용
		//MultipartRequest(요청정보, 저장위치, 최대크기, 인코딩, 리네임정책)
		//사용자값을 db입력 처리.
		//목록이동.
		String dir = req.getServletContext().getRealPath("upload");
		System.out.println("dir : " + dir);
		int maxSize = 5 * 1024 * 1024; //1024byte=1kb 1000000
		String enc="UTF-8";
		try {
			MultipartRequest multi = // 
			new MultipartRequest(req,dir,maxSize,enc,new DefaultFileRenamePolicy());
	
			//사용자 입력값 처리.
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String subject = multi.getParameter("subject");
			String attach = multi.getFilesystemName("attach");
			
			NoticeVO vo= new NoticeVO();
			vo.setNoticeTitle(title);
			vo.setNoticeWriter(writer);
			vo.setNoticeSubject(subject);
			vo.setAttach(attach);
			
			NoticeService service= new NoticeServiceMybatis(); //NoticeService에 정의하고 NoticeServiceMybatis()에서 구현
			if(service.addNotice(vo)){
				//정상처리. 목록으로 이동.
				resp.sendRedirect("noticeList.do");
			}else {
				try {
					req.getRequestDispatcher("WEB-INF/notice/noticeForm.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
