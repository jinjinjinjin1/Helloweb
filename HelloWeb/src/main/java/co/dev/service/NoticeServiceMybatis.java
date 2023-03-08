package co.dev.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dev.common.DataSource;
import co.dev.mapper.NoticeMapper;
import co.dev.vo.NoticeVO;

public class NoticeServiceMybatis implements NoticeService {
	
	
	//jdbc: NoticeDAO dao;
	
	//mybatis: mapper 사용;
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList(int page) { //목록.
		//return mapper.noticeList();
		return mapper.noticeListWithPaging(page);
	}

	@Override
	public boolean addNotice(NoticeVO vo) {	//등록.
		int r = mapper.insertNotice(vo);
		//sqlSession.commit(); //다른 세션에서 자동 커밋 반영.
		return r == 1;
	}

	@Override
	public NoticeVO getNotice(int nid) {
		mapper.updateCount(nid); //조회수증가
		return mapper.selectNotice(nid);
	}

	@Override
	public int getTotalCount() { //전체건수조회
		return mapper.getTotalCount();
	}

	@Override
	public boolean updateNotice(NoticeVO vo) {
		return mapper.updateNotice(vo) == 1;
	}

	@Override
	public boolean deleteNotice(int nid) {
		return 0;
	}



}
