package co.yedam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceImpl;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//첨부파일: 서버의 특정위치에 업로드. cos.jar 라는 라이브러리 사용
		//MultipartRequest(요청정보, 저장위치, 최대크기, 인코딩, 리네임정책)
		//사용자값을 db입력 처리.

		//사용자 입력값 처리.
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author =request.getParameter("author");
		String press = request.getParameter("press");
		String desc = request.getParameter("desc");
		int price = Integer.parseInt(request.getParameter("price"));
		

		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookTitle(title);
		vo.setBookAuthor(author);
		vo.setBookPress(press);
		vo.setBookDesc(desc);
		vo.setBookPrice(price);
		
		System.out.println("입력: "+ vo);
		
		
		BookService service = new BookServiceImpl();
		
		boolean result = service.addBook(vo); 
		System.out.println(result);
		
		if(result) {
			System.out.println("성공.");
			request.setAttribute("message", "성공"); 
			request.setAttribute("code", vo.getBookCode());
		}else {
			System.out.println("예외.");
			request.setAttribute("message", "예외");
		}
		
		//요청을 재지정해주는 객체 RequestDispatcher
				RequestDispatcher rd = //
						request.getRequestDispatcher("WEB-INF/book/bookList.jsp");
		
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				
		
		
	}

}
