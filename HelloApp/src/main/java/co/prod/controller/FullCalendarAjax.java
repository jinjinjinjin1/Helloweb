package co.prod.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.CalendarVO;

public class FullCalendarAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProductService service = new ProductServiceImpl();
		List<CalendarVO> list = service.calendarInfo();
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		return json+".ajax";
	}

}
