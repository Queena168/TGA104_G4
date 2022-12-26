package com.tibame.product.model;

import java.util.List;
import java.util.Map;

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public ProductVO findByPrimaryKey(Integer productNo);
    public List<ProductVO> getAll();
    public List<ProductVO> showAll();
    public List<Map<String, Object>> showAll2();
    
    public List<Map<String, Object>> listAllProduct();
}
