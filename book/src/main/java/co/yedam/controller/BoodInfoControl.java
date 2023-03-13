package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodInfoControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookCode = request.getParameter("bookCode");
		
		//bookCode를 활용해서 BookVO객체를 반환하는 메소드(BookService,BookVO)
		BookService service = new BookServiceMybatis();
		BookVO vo = service.getBookInfo(bookCode);
		System.out.println(vo);
		request.setAttribute("book", vo);
		
		try {
			request.getRequestDispatcher("WEB-INF/book/bookInfo.jsp").forward(request, response);
			
		}catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
