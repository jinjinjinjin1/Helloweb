package co.prod.vo;

import lombok.Data;

@Data
public class ReplyVO {
//	 reply_no number primary key,
//	 reply_writer varchar2(100) not null,
//	 reply_content varchar2(200) not null,
//	 reply_date date default sysdate,
//	 product_code varchar2(10)
	
	private int replyNo;
	private String replyWriter;
	private String replyContent;
	private String replyDate;
	private String productCode;
	
}
