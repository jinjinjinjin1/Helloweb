package co.prod.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.ProductMapper;
import co.prod.vo.CalendarVO;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public class ProductServiceImpl implements ProductService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> products() {
		// TODO Auto-generated method stub
		return mapper.products();
	}

	@Override
	public ProductVO getProduct(String code) {
		return mapper.selectProduct(code);
	}

	@Override
	public List<ReplyVO> replyList(String code) {
		// TODO Auto-generated method stub
		return mapper.replyList(code);
	}

	@Override
	public boolean removeReply(int replyId) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(replyId) == 1;
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertReply(vo) ==1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		// TODO Auto-generated method stub
		return mapper.selectReply(replyId);
	}

	@Override
	public boolean modifyReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.modifyReply(vo)==1;
	}

	@Override
	public List<Map<String, Object>> chartInfo() {
		return mapper.chartInfo();
	}

	@Override
	public List<CalendarVO> calendarInfo() {
		// TODO Auto-generated method stub
		return mapper.calendarInfo();
	}

	@Override
	public boolean addCal(CalendarVO vo) {
		
		return mapper.insertCal(vo) ==1;
	}


}
