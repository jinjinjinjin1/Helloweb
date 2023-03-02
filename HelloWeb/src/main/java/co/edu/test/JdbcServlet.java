package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;


@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보의 인코딩 방식 지정.
		resp.setCharacterEncoding("utf-8"); //응답 정보의 인코딩 방식 지정.
		resp.setContentType("text/html;charset=utf-8"); //컨텐트 타입 지정.
		EmpDAO dao= new EmpDAO();
		//get or post 요청을 구분해서 처리.
		//get 이면 조회. post이면 입력.
		Map<String,Object> result = dao.getEmpInfo(101);
		Set<String> set = result.keySet(); //키부분만 set 컬렉션.
		for(String key : set) {
			System.out.println("key:" + key + ", val: " + result.get(key));
		}
		
		//페이지 출력. 사번/이름(이름 + 성씨) /급여 / 부서 
		PrintWriter out = resp.getWriter();
		
		
		
		
		//페이지 작성.
		//{키:값},{키:값},{키:값},{키:값},{키:값},{키:값},=>result
		System.out.println("id:"+ result.get("id")+"\n성:" + result.get("firstName") + "\n이름: " + result.get("lastName") + "\n급여:" + result.get("salary") +"\n부서: " +result.get("department"));
	
		
		
		out.print("<a href = 'temp.html'>조회-등록으로 이동</a>");
		out.close();
		
		
	}

}
