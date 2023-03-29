package co.prod.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.service.ProductServiceMybatis;
import co.prod.vo.ProductVO;

public class ProductListControl implements Control {

//	public String execute(HttpServletRequest req, HttpServletResponse resp) {
//		//db 결과 -> attribute("list")
//		//상품목록 
//		//return "product/productList.tiles"; //실행할 페이지.
//	ProductService service = new ProductServiceMybatis();
//
//	List<ProductVO> list = service.products();
//
//	
//	req.setAttribute("list", list);
//	RequestDispatcher rd = req.getRequestDispatcher("product/productList.tiles");
//	try {
//		rd.forward(req, resp);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return "product/productList.tiles";
//	
//	
//	
//	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// db 결과 -> attribute("list")
		ProductService service = new ProductServiceImpl();
		request.setAttribute("products", service.products());
		return "product/productList.tiles"; // 실행할 페이지.
	}
	
}
