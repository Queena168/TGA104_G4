package com.designerOrder.model;
import java.util.*;
public interface DesignerOrderDAO_interface {
	public void insert(DesignerOrderVO designerOrderVO);
	public void update(DesignerOrderVO designerOrderVO);
	public void delete(Integer orderNo);
	public DesignerOrderVO findDesignerOrder(Integer orderNo);
	public List<DesignerOrderVO> getAll();
	public List<DesignerOrderVO> getAllMyOrder(Integer designerNo);
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//     public List<EmpVO> getAll(Map<String, String[]> map); 
}
