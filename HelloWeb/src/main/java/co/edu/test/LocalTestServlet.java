package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {

	// 서블릿의 지역번수 / 멤버변수
	// 상태유지 기술.
	// http: 요청 -> 응답: 요청,응답 처리가 되면 메모리 사라짐.
	// Client A: 요청 -> 응답.
	// Client B: 요청 -> 응답.

	// 클라이언트 : 서버 .
	// 쿠키 : 요청, 로그인 한 유저별로 세션, 컨텍스트(애플리케이션)

	String str; // 필드. 객체생성:멤버 변수
	
	@Override //오버라이드 자동완성 기능 ctrl + spacebar
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		str = req.getParameter("msg"); //멤버변수로써 공유함
		//String str = req.getParameter("msg"); //지역번수로써 사용함
		int num = 0;
		resp.setContentType("text/html;charset=utf-8");
		
		//출력스트림생성.
		PrintWriter out = resp.getWriter();
		out.print("<h3>처리결과(지역변수)</h3>");
		
		while(num ++ <10) {
			out.print(str + " : " + num + "<br>");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h3>Done</h3>");
		out.close();
		
	}

}
