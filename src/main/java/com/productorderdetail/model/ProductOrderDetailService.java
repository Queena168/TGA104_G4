package com.productorderdetail.model;

import java.util.List;

import com.cart.model.CartDAO_interface;
import com.cart.model.CartJDBCDAO;
import com.cart.model.CartVO;

public class ProductOrderDetailService {
	private ProductOrderDetailDAO_interface dao;

	public ProductOrderDetailService() {
		dao = new ProductOrderDetailJDBCDAO();
	}

	public ProductOrderDetailVO addProductOrderDetail(Integer orderNo, Integer productNo, Integer qty) {

		ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();

		productOrderDetailVO.setOrderNo(orderNo);
		productOrderDetailVO.setProductNo(productNo);
		productOrderDetailVO.setQty(qty);
		dao.insert(productOrderDetailVO);

		return productOrderDetailVO;

	}

	public ProductOrderDetailVO updateProductOrderDetail(Integer orderDetailNo, Integer orderNo, Integer productNo, Integer qty) {

		ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();

		productOrderDetailVO.setOrderDetailNo(orderDetailNo);
		productOrderDetailVO.setOrderNo(orderNo);
		productOrderDetailVO.setProductNo(productNo);
		productOrderDetailVO.setQty(qty);
		dao.update(productOrderDetailVO);

		return productOrderDetailVO;
	}

	public void deleteProductOrderDetail(Integer orderDetailNo) {
		dao.delete(orderDetailNo);
	}

	public ProductOrderDetailVO getOneProductOrderDetail(Integer orderDetailNo) {
		return dao.findByPrimaryKey(orderDetailNo);
	}

	public List<ProductOrderDetailVO> getAll() {
		return dao.getAll();
	}
}
