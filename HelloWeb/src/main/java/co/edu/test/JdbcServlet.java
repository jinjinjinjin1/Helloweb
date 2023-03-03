package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
		req.setCharacterEncoding("utf-8"); // 요청정보의 인코딩 방식 지정.
		resp.setCharacterEncoding("utf-8"); // 응답정보의 인코딩 방식 지정.
		resp.setContentType("text/html;charset=utf-8"); // 컨텐트 타입 지정.
		EmpDAO dao = new EmpDAO();
	
		
		// get or post 요청을 구분해서 처리.	
		
		
		// get 이면 조회
		//post이면 입력.
		
		
		String eid = req.getParameter("eid");
		//code...
		
		// 조회용으로 겟 방식 처리.
		if (req.getMethod().equals("GET")) {
			Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(eid));
			Set<String> set = result.keySet(); // 키부분만 set 컬렉션.
			for (String key : set) {
				System.out.println("key:" + key + ", val: " + result.get(key));
			}

		} else if (req.getMethod().equals("POST")) {
			
			// 등록 post 방식 처리
			String first = req.getParameter("first");
			String last = req.getParameter("last");
			String hire = req.getParameter("hire");
			String job = req.getParameter("job");
			String email = req.getParameter("email");

			// 영속계층의 기능. EmpDAO에.
			Map<String, Object> map = new HashMap<>();
			map.put("eid", eid);
			map.put("first", first);
			map.put("last", last);
			map.put("hire", hire);
			map.put("job", job);
			map.put("email", email);

			int result = dao.insertEmp(map);
			System.out.println(result);

			// 페이지 출력. 사번/이름(이름 + 성씨) /급여 / 부서
			PrintWriter out = resp.getWriter();

			// 페이지 작성.
			// {키:값},{키:값},{키:값},{키:값},{키:값},{키:값},=>result
			System.out.println("id:" + map.get("eid") + "\n성:" + map.get("first") + "\n이름: " + map.get("last")
					+ "\n입사일:" + map.get("hire") + "\n직무: " + map.get("job")+ "\n이메일: " + map.get("email"));

			out.print("<a href = 'temp.html'>조회-등록으로 이동</a>");
			out.close();

		}
	}
}
