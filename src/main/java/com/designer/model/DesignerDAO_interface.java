package com.designer.model;

import java.util.*;





public interface DesignerDAO_interface {
	   public void insert(DesignerVO designerVO);
	   public void insertDesigner(DesignerVO designerVO);
       public void update(DesignerVO designerVO);
       public void updatenoPic(DesignerVO designerVO);
       public void delete(Integer designerNo);
       public DesignerVO login(String designerAccount,String designerPassword);   
       public DesignerVO findByPrimaryKey(Integer designerNo);
       public List<DesignerVO> getAll();
       //萬用複合查詢(傳入參數型態Map)(回傳 List)
//     public List<EmpVO> getAll(Map<String, String[]> map); 
       
   	//查詢專長設計師(一對多)(回傳 Set)
//       public Set<DesignerExpertiseVO> getEmpsByDeptno(Integer designerExpertiseVO);
}
