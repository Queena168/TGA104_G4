package com.tibame.productpic.model;

import java.util.List;
import java.util.Map;

public interface ProductPicDAO_interface {
	public void insert(ProductPicVO productPicVO);
	public void update(ProductPicVO productPicVO);
    public ProductPicVO findByPrimaryKey(Integer productPicNo);
    public List<ProductPicVO> getAll();
    
    public ProductPicVO showOnePic(Integer productNo);
    public List<ProductPicVO> showAllPic();
    
    public List<Map<String, Object>> showAll2();
    
    public List<Map<String, Object>> listAllProduct();
}
