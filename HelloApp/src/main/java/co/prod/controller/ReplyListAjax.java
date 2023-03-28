package co.prod.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ReplyVO;

public class ReplyListAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//상품한건에 대한 댓글 목록 -> json 포맷의 데이터 반환.
		String code = request.getParameter("code");
		
		ProductService service = new ProductServiceImpl();
		List<ReplyVO> list = service.replyList(code);
		
		//json 포맷으로 생성
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		return json+".ajax";
	}

}
