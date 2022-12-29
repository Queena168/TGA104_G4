package com.tibame.productorder.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {
	@Autowired
	private ProductOrderDAO_interface dao;
	
//	public ProductOrderService() {
//		dao = new ProductOrderJDBCDAO();
//	}
	
	public ProductOrderVO addProductOrder(
			Integer memberNo, String  receiverName, String receiverPhone, String receiverAddress, 
			Integer totalQTY, Integer totalAmount, String invoiceNo, String businessNumber, java.sql.Date paidDate, 
			java.sql.Date shipDate, String orderStatus) {

		ProductOrderVO productOrderVO = new ProductOrderVO();
		productOrderVO = new ProductOrderVO();
		productOrderVO.setMemberNo(memberNo);
		productOrderVO.setReceiverName(receiverName);
		productOrderVO.setReceiverPhone(receiverPhone);
		productOrderVO.setReceiverAddress(receiverAddress);
		productOrderVO.setTotalQTY(totalQTY);
		productOrderVO.setTotalAmount(totalAmount);
		productOrderVO.setInvoiceNo(invoiceNo);
		productOrderVO.setBusinessNumber(businessNumber);
//		productOrderVO.setPaidDate(paidDate);
		productOrderVO.setShipDate(shipDate);
		productOrderVO.setOrderStatus(orderStatus);
		dao.insert(productOrderVO);

		return productOrderVO;
	}
	
	public ProductOrderVO updateProductOrder(Integer orderNo, Integer memberNo, String  receiverName, String receiverPhone, String receiverAddress, 
			Integer totalQTY, Integer totalAmount, String invoiceNo, String businessNumber, java.sql.Date paidDate, 
			java.sql.Date shipDate, String orderStatus) {

		ProductOrderVO productOrderVO = new ProductOrderVO();
		
		productOrderVO.setOrderNo(orderNo);
		productOrderVO.setMemberNo(memberNo);
		productOrderVO.setReceiverName(receiverName);
		productOrderVO.setReceiverPhone(receiverPhone);
		productOrderVO.setReceiverAddress(receiverAddress);
		productOrderVO.setTotalQTY(totalQTY);
		productOrderVO.setTotalAmount(totalAmount);
		productOrderVO.setInvoiceNo(invoiceNo);
		productOrderVO.setBusinessNumber(businessNumber);
//		productOrderVO.setPaidDate(paidDate);
		productOrderVO.setShipDate(shipDate);
		productOrderVO.setOrderStatus(orderStatus);
		dao.update(productOrderVO);

		return productOrderVO;
	}
	
	public void deleteProductOrder(Integer orderNo, String orderStatus) {
		ProductOrderVO productOrderVO = new ProductOrderVO();
		
		productOrderVO.setOrderNo(orderNo);
		productOrderVO.setOrderStatus(orderStatus);
		dao.delete(productOrderVO);
	}
	
	public ProductOrderVO getOneProductOrder(Integer orderNo) {
		return dao.findByPrimaryKey(orderNo);
	}
	
	public List<ProductOrderVO> getAll() {
		return dao.getAll();
	}
	
	
	public ProductOrderVO updateOrderStatus(Integer orderNo, String orderStatus) {

		ProductOrderVO productOrderVO = new ProductOrderVO();
		
		productOrderVO.setOrderNo(orderNo);
		productOrderVO.setOrderStatus(orderStatus);
		dao.updateOrderStatus(productOrderVO);

		return productOrderVO;
	}
}
