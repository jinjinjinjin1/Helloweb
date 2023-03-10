package co.prod.mapper;

import java.util.List;
import co.prod.service.ProductService;
import co.prod.vo.ProductVO;

public interface ProductMapper {
	public List<ProductVO> products();
}
