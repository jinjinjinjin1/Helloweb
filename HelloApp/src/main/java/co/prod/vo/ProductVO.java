package co.prod.vo;

import lombok.Data;

@Data
public class ProductVO {
	/*상품코드:product_code (varchar2)
	상품명:product_name (varchar2)
	원가격:origin_price (int)
	할인가격:sale_price (int)
	상품설명:product_desc (varchar2)
	평점:like_it        number(3,1)
	이미지:image        (varchar2) 
	 * 
	 */
	
	//필드 
	private String productCode;
	private String productName;
	private int originPrice;
	private int salePrice;
	private String productDesc;
	private double likeIt;
	private String image;
}
