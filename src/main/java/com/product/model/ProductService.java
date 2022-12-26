package com.product.model;

import java.util.List;
import java.util.Map;

public class ProductService {
	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductJDBCDAO();
	}
	
	public ProductVO addProduct(Integer productTypeNo, String  productName,
			Integer stock, Integer price, String productDescription, String productStatus, Integer adminNo) {

		ProductVO productVO = new ProductVO();
		productVO.setProductTypeNo(productTypeNo);
		productVO.setProductName(productName);
		productVO.setStock(stock);
		productVO.setPrice(price);
		productVO.setProductDescription(productDescription);
		productVO.setProductStatus(productStatus);
		productVO.setAdminNo(adminNo);
		dao.insert(productVO);

		return productVO;
	}
	
	public ProductVO updateProduct(Integer productNo, Integer productTypeNo, String  productName,
			Integer stock, Integer price, String productDescription, String productStatus, Integer adminNo) {

		ProductVO productVO = new ProductVO();
		
		productVO.setProductNo(productNo);
		productVO.setProductTypeNo(productTypeNo);
		productVO.setProductName(productName);
		productVO.setStock(stock);
		productVO.setPrice(price);
		productVO.setProductDescription(productDescription);
		productVO.setProductStatus(productStatus);
		productVO.setAdminNo(adminNo);
		dao.update(productVO);

		return productVO;
	}
	
	public ProductVO getOneProduct(Integer productno) {
		return dao.findByPrimaryKey(productno);
	}
	
	public List<ProductVO> getAll() {
		return dao.getAll();
	}
	
	public List<Map<String, Object>> showAll2() {
		return dao.showAll2();
	}
	
	public List<Map<String, Object>> listAllProduct() {
		return dao.listAllProduct();
	}
}
