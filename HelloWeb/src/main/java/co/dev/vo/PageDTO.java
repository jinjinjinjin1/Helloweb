package co.dev.vo;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage; //첫페이지
	private int endPage; //마지막페이지.
	private boolean prev,next; //이전, 다음페이지.
	private int page; //현재페이지.
	
	public PageDTO(int page, int total) {
		//total 235건 ->24페이지가 마지막
		this.page=page;
		this.endPage=(int)Math.ceil(page/10.0) * 10; //올림을 처리하기위해서 ceil. 1~10 =>마지막 페이지는 10
		this.startPage=this.endPage-9; //10
		
		int realEnd = (int)Math.ceil(total * 1.0 / 10); //24
		if(this.endPage > realEnd) {
			this.endPage= realEnd; //실제현재페이지 22 -> 계산상으로는 30이지만 실제페이지를 24로
		}
		
		this.prev = this.startPage >1; //이전페이지가 있다면 1보다 크다 
		this.next = this.endPage < realEnd;  //3-> 10 		
	}
	
}
