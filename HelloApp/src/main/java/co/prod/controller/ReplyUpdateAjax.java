package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public class ReplyUpdateAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String rno= request.getParameter("replyNo");
		String rcontent = request.getParameter("content");
		
		ReplyVO vo = new ReplyVO();
		vo.setReplyNo(Integer.parseInt(rno));
		vo.setReplyContent(rcontent);
		
		ProductService service = new ProductServiceImpl();
		boolean result=service.modifyReply(vo);
		ReplyVO rvo = service.getReply(Integer.parseInt(rno));
		
		Map<String,Object> resultMap= new HashMap<>();
		
		if(result) {
			resultMap.put("retCode", "Success"); //포장상자, 내용물
			resultMap.put("reply",rvo); //포장상자, 내용물
		}else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		
		Gson gson = new GsonBuilder().create(); //준비작업
		String json =gson.toJson(resultMap);		
		
		return json+".ajax";
	}

}
