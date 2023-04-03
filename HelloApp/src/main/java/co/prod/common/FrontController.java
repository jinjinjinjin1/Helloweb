package co.prod.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.ChartAjax;
import co.prod.controller.ChartControl;
import co.prod.controller.CovidForm;
import co.prod.controller.FullCalendarAjax;
import co.prod.controller.FullCalendarForm;
import co.prod.controller.MapForm;
import co.prod.controller.MemberAddAjax;
import co.prod.controller.MemberListAjax;
import co.prod.controller.MemberListControl;
import co.prod.controller.MemberRemoveAjax;
import co.prod.controller.MemberRemoveJquery;
import co.prod.controller.MembersControl;
import co.prod.controller.ProductInfoControl;
import co.prod.controller.ProductListControl;
import co.prod.controller.ReplyAddAjax;
import co.prod.controller.ReplyListAjax;
import co.prod.controller.ReplyRemoveAjax;
import co.prod.controller.ReplySearchAjax;
import co.prod.controller.ReplyUpdateAjax;
import co.prod.controller.calendarAddAjax;
import co.prod.controller.memberAddJquery;
//import co.prod.controller.calendarRemoveAjax;
import co.prod.controller.memberJquery;
import co.prod.controller.memberListJquery;

public class FrontController extends HttpServlet{
	
	private Map<String , Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	 // url <-> control
	map.put("/memberList.do", new MemberListControl());
	map.put("/members.do", new MembersControl());
	//Ajax 호출(SPA처리)
	map.put("/memberListAjax.do", new MemberListAjax());
	map.put("/memberRemoveAjax.do", new MemberRemoveAjax());
	map.put("/memberAddAjax.do", new MemberAddAjax());
	
	//jquery용 ajx.
	map.put("/memberJquery.do", new memberJquery());
	//목록을 가지고 오도록.memberListJquery.do
	map.put("/memberListJquery.do", new memberListJquery());
	//회원 추가
	map.put("/memberAddJquery.do", new memberAddJquery());
	//회원삭제
	map.put("/memberRemoveJquery.do", new MemberRemoveJquery());
	
	
	
	
	//상품목록.
	map.put("/productList.do", new ProductListControl());
	//상품한건정보.
	map.put("/productInfo.do", new ProductInfoControl());
	
	
	//상품댓글정보.목록 
	map.put("/replyListAjax.do", new ReplyListAjax());
	//상품댓글삭제 
	map.put("/replyRemoveAjax.do", new ReplyRemoveAjax());
	//상품댓글등록
	map.put("/replyAddAjax.do", new ReplyAddAjax());
	//상품댓글번호 한건조회.
	map.put("/replySearchAjax.do", new ReplySearchAjax());
	//상품댓글 수정
	map.put("/replyUpdateAjax.do", new ReplyUpdateAjax());
	
	
	//chart
	map.put("/chart.do", new ChartControl());
	//chart데이터.
	map.put("/chartAjax.do", new ChartAjax());
	//covid.
	map.put("/covid19.do", new CovidForm());
	//map api
	map.put("/map.do", new MapForm());
	//calendar api
	map.put("/fullcalendar.do", new FullCalendarForm());
	//calendar 일정 조회
	map.put("/fullcalendarAjax.do", new FullCalendarAjax());
	//calendar 일정 등록
	map.put("/calendalAddAjax.do", new calendarAddAjax());
	//calendar 일정 삭제
	//map.put("/calendalRemoveAjax.do", new calendarRemoveAjax());
	
	
	
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI(); //주소 넘어옴 localhost:8081
		//System.out.println(uri);
		String context = req.getContextPath(); //프로젝트 이름 넘어옴 -> HelloApp
		//System.out.println(context);
		String page = uri.substring(context.length());
		System.out.println("do page: " + page);
		
		Control command = map.get(page);
		String viewPage = command.exec(req,resp); //  product/productList.tiles
		
		if(viewPage.endsWith(".jsp")){  //memberList.do
			viewPage = "/WEB-INF/views/" + viewPage;
	//	}else if (viewPage.endsWith("tiles")) { //members.do
	//     req.getRequestDispatcher(viewPage);
		}else if(viewPage.endsWith(".ajax")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().append(viewPage.substring(0,viewPage.length()-5));
			return;
		}
		
	
		//페이지 재지정
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
	
}
