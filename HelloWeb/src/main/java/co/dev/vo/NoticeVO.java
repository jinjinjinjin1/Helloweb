package co.dev.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	//notice테이블의 데이터 담아줌
	
	private int noticeId; //oracle : notice_id => noticeId
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date createDate;
	private int hitCount;
	private String attach;
	
	
	
	
	
	
}
