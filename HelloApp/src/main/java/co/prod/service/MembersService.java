package co.prod.service;

import java.util.List;

import co.prod.vo.MembersVO;

public interface MembersService {
	//회원목록
	public List<MembersVO> get2Members();
	
	//회원추가
	public boolean addMembers(MembersVO vo);
}
