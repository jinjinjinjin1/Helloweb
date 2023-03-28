package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.ProductMapper;
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


}
