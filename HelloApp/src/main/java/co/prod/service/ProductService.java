package co.prod.service;

import java.util.List;
import java.util.Map;

import co.prod.vo.CalendarVO;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductService {
	
	public List<ProductVO> products(); //목록보기
	public ProductVO getProduct(String code);
	
	
	//상품에 대한 댓글목록.
	public List<ReplyVO> replyList(String code);
	//댓글삭제
	public boolean removeReply(int replyId);
	//댓글등록
	public boolean addReply(ReplyVO vo);
	//댓글 한건 조회
	public ReplyVO getReply(int replyId);
	//댓글 수정
	public boolean modifyReply(ReplyVO vo);
	
	
	//chart
	public List<Map<String ,Object>> chartInfo();
	
	
	//calendar 목록 조회
	public List<CalendarVO> calendarInfo();
	//calendar 일정 등록
	public boolean addCal(CalendarVO vo);
}
