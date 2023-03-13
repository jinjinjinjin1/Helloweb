package co.yedam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;

import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BookListControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//도서목록. 
		//WEB-INF/book/bookList.jsp
		
		//BookService service = new BookServiceImpl();
		BookService service = new BookServiceMybatis();
		
		List<BookVO> list = service.bookList();
		
		request.setAttribute("book", list); //context: sc.setAttribute("param", map)
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/book/bookList.jsp");
		
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
 
}
