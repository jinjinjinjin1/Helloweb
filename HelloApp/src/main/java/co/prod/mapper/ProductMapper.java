package co.prod.mapper;

import java.util.List;
import java.util.Map;

import co.prod.service.ProductService;
import co.prod.vo.CalendarVO;
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
	//댓글조회
	public ReplyVO selectReply(int replyId);
	//댓글수정
	public int modifyReply(ReplyVO vo);
	
	
	//chart.부서별인원현황.
	public List<Map<String, Object>> chartInfo(); //map타입을 컬렉션타입으로 받기위해서 List로
	
	
	//calendar.정보
	public List<CalendarVO> calendarInfo();
	//calendar 등록
	public int insertCal(CalendarVO vo);
	
}
