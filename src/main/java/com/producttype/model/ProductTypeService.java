package com.producttype.model;

import java.util.List;

public class ProductTypeService {
	private ProductTypeDAO_interface dao;

	public ProductTypeService() {
		dao = new ProductTypeJDBCDAO();
	}
	
	public ProductTypeVO addProductType(String productTypeName) {

		ProductTypeVO productTypeVO = new ProductTypeVO();
		productTypeVO.setProductTypeName(productTypeName);
		dao.insert(productTypeVO);

		return productTypeVO;
	}
	
	public ProductTypeVO updateProductType(Integer productTypeNo, String productTypeName) {

		ProductTypeVO productTypeVO = new ProductTypeVO();
		
		productTypeVO.setProductTypeNo(productTypeNo);
		productTypeVO.setProductTypeName(productTypeName);
		dao.update(productTypeVO);

		return productTypeVO;
	}
	
	public void deleteProductType(Integer productTypeNo) {
		dao.delete(productTypeNo);
	}
	
	public ProductTypeVO getOneProductType(Integer productTypeNo) {
		return dao.findByPrimaryKey(productTypeNo);
	}
	
	public List<ProductTypeVO> getAll() {
		return dao.getAll();
	}
}
