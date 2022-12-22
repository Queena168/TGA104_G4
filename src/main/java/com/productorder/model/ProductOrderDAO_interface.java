package com.productorder.model;

import java.util.List;


public interface ProductOrderDAO_interface {
	public boolean insert(ProductOrderVO productOrderVO);
    public void update(ProductOrderVO productOrderVO);
    public void delete(ProductOrderVO productOrderVO);
    public ProductOrderVO findByPrimaryKey(Integer orderNo);
    public List<ProductOrderVO> getAll();
    
    
    public void addOrders(ProductOrderVO productOrderVO);
    public void updateOrderStatus(ProductOrderVO productOrderVO);
    
}
