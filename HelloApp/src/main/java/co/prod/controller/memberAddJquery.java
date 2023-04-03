package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.MembersService;
import co.prod.service.MembersServiceMybatis;
import co.prod.vo.MembersVO;

public class memberAddJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MembersVO vo = new MembersVO ();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberAddr(request.getParameter("memberAddr"));
		vo.setMemberPw(request.getParameter("memberPw"));
		vo.setMemberTel(request.getParameter("memberTel"));
		
		MembersService service = new MembersServiceMybatis(); 
		boolean result = service.addMembers(vo);
		Map<String,Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		if(result) {
			map.put("retCode", "Success");
			map.put("member", vo);
		}else {
			map.put("retCode", "Fail");
			map.put("member", null);
		}
		json = gson.toJson(map);
		
		return json + ".ajax";
	}

}
