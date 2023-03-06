package co.dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.EmpService;
import co.dev.service.EmpServiceImpl;
import co.dev.vo.EmpVO;


public class EmpListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 사원목록. //WEB-INF/member/empList.jsp
		EmpService service = new EmpServiceImpl();
		List<EmpVO> list = service.getClass();
		
	}

}
