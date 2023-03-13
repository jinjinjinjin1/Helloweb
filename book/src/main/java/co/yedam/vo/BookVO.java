package co.yedam.vo;

import lombok.Data;

@Data
public class BookVO {
	/*
	 * BOOK_CODE   NOT NULL VARCHAR2(15)  
	BOOK_TITLE  NOT NULL VARCHAR2(50)  
	BOOK_AUTHOR NOT NULL VARCHAR2(50)  
	BOOK_PRESS  NOT NULL VARCHAR2(50)  
	BOOK_DESC            VARCHAR2(500) 
	BOOK_PRICE           NUMBER   
	 */
	
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookPress;
	private String bookDesc;
	private int bookPrice;
	
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	
}
