package co.prod.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.service.MembersService;
import co.prod.service.MembersServiceMybatis;
import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;

public class memberListJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
	
		MembersService service = new MembersServiceMybatis();
		
		List<MembersVO> list = service.get2Members();
		
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
	
		
		return json + ".ajax";
	}

}
