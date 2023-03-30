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
import co.prod.vo.CalendarVO;

public class calendarAddAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CalendarVO vo = new CalendarVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setStartDate(request.getParameter("startDate"));
		vo.setEndDate(request.getParameter("endDate"));
		
		ProductService service = new ProductServiceImpl();
		boolean result = service.addCal(vo);
		Map<String, Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		String json ="";
		
		if(result) {
			map.put("retCode", "Success");
			map.put("calendar", vo);
		}else {
			map.put("retCode", "Fail");
			map.put("calendar", null);
		}
		json = gson.toJson(map);
		
		
		return json+".ajax";
	}

}
