package co.prod.mapper;

import java.util.List;
import co.prod.service.ProductService;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductMapper {
	//상품목록
	public List<ProductVO> products();
	public ProductVO selectProduct(String code);
	
	//댓글목록
	public List<ReplyVO> replyList(String code);
	//댓글삭제
	public int deleteReply(int replyId);
	//댓글 등록
	public int insertReply(ReplyVO vo);
	//댓글수정
}
