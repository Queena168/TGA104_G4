package com.tibame.productpic.model;

import java.util.List;
import java.util.Map;

public class ProductPicService {
	private ProductPicDAO_interface dao;

	public ProductPicService() {
		dao = new ProductPicJDBCDAO();
	}
	
	public ProductPicVO addProductPic(Integer productNo, byte[] pic) {

		ProductPicVO productPicVO = new ProductPicVO();
		productPicVO.setProductNo(productNo);
		productPicVO.setPic(pic);

		dao.insert(productPicVO);

		return productPicVO;
	}
	
	public ProductPicVO updateProductPic(Integer productPicNo, Integer productNo, byte[] pic) {

		ProductPicVO productPicVO = new ProductPicVO();
		
		productPicVO.setProductPicNo(productPicNo);
		productPicVO.setProductNo(productNo);
		productPicVO.setPic(pic);
		dao.update(productPicVO);

		return productPicVO;
	}
		
	public ProductPicVO getOnePic(Integer productPicNo) {
		return dao.findByPrimaryKey(productPicNo);
	}
	
	public List<ProductPicVO> getAll() {
		return dao.getAll();
	}
	
	public ProductPicVO showOnePic(Integer productNo) {
		return dao.showOnePic(productNo);
	}
	
	public List<ProductPicVO> showAllPic() {
		return dao.showAllPic();
	}
	
	public List<Map<String, Object>> showAll2() {
		return dao.showAll2();
	}
	
	public List<Map<String, Object>> listAllProduct() {
		return dao.listAllProduct();
	}
}
