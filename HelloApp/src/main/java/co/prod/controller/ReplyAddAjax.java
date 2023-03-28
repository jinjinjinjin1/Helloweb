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
import co.prod.vo.ReplyVO;

public class ReplyAddAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//댓글 등록하는 기능 ...등록시에는 반환값 신경써야함 
		String wrtiter = request.getParameter("writer");
		String content = request.getParameter("content");
		String pcode= request.getParameter("pcode");
		
		ReplyVO vo = new ReplyVO();
		vo.setProductCode(pcode);
		vo.setReplyContent(content);
		vo.setReplyWriter(wrtiter);
		
		ProductService service = new ProductServiceImpl();
		//mapper: insertReply로 작성.
		boolean result = service.addReply(vo);
		//{"retCode" : "Success","reply": vo}
		Map<String,Object> resultMap= new HashMap<>(); 
		if(result) {
			resultMap.put("retCode", "Success");
			resultMap.put("reply",vo);
			
		}else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap);
		
	
		return json + ".ajax";
	}

}
