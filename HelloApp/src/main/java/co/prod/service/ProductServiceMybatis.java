package co.prod.service;

import java.util.List;

import co.prod.service.ProductService;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public class ProductServiceMybatis implements ProductService {
	@Override
	public List<ProductVO> products() {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public List<ProductVO> productList() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ProductVO getProduct(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReplyVO> replyList(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeReply(int replyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	

}