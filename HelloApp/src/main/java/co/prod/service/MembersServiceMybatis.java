package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.MemberMapper;
import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;

public class MembersServiceMybatis implements MembersService{
	
	//jdbc : MemberDAO dao;가지고 처리
	//mybatis : DataSource:SqlSessionFactory-> SqlSession;
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	//Mapper.xml파일의 메소드를 호출.
	private MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MembersVO> get2Members() {
		return mapper.get2Members();
	}

	@Override
	public boolean addMembers(MembersVO vo) {
		return mapper.insertMembers(vo)==1;
	}

	
	

	
}
