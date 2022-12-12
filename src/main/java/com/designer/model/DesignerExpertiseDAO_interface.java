package com.designer.model;
import java.util.*;
public interface DesignerExpertiseDAO_interface {
	   public void insert(DesignerExpertiseVO designerexpertiseVO);
       public void update(DesignerExpertiseVO designerexpertiseVO);
       public void delete(Integer designerExpertiseNo);
       public DesignerExpertiseVO findDesignerExpertiseNo(Integer designerExpertiseNo);
       public Set<DesignerExpertiseVO> getAll();
       public List<DesignerExpertiseVO> getMyExpertise(Integer designerNo);
       public DesignerExpertiseVO getMyExpertises(Integer designerNo);
       //萬用複合查詢(傳入參數型態Map)(回傳 List)
//     public List<EmpVO> getAll(Map<String, String[]> map); 
}
