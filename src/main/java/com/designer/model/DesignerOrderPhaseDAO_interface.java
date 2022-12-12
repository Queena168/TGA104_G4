package com.designer.model;
import java.util.*;
public interface DesignerOrderPhaseDAO_interface {
	public void insert(DesignerOrderPhaseVO designerOrderPhaseVO);
	public void update(DesignerOrderPhaseVO designerOrderPhaseVO);
	public void delete(Integer phaseNo);
	public DesignerOrderPhaseVO findDesignerOrderPhase(Integer phaseNo);
	public List<DesignerOrderPhaseVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//     public List<EmpVO> getAll(Map<String, String[]> map); 
}
