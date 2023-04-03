package co.prod.common;

import java.util.ArrayList;
import java.util.List;

import co.prod.service.MembersService;
import co.prod.service.MembersServiceMybatis;
import co.prod.vo.MembersVO;

public class SampleExe {

	public static void main(String[] args) {
		MembersService service = new MembersServiceMybatis();
		List<MembersVO> list = new ArrayList<>();
		//list.add(new MembersVO)

	}

}
