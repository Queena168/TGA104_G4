package com.tibame.designer.model;
import java.util.List;
public interface DesignerOrderPhaseDAO_interface {
	public void insert(DesignerOrderPhaseVO designerOrderPhaseVO);
	public void update(DesignerOrderPhaseVO designerOrderPhaseVO);
	public void insertDesignerOrderPhaseConstruction(DesignerOrderPhaseVO designerOrderPhaseVO);
	public void updateDesignerOrderPhasePayment(DesignerOrderPhaseVO designerOrderPhaseVO);
	public List<DesignerOrderPhaseVO> findDesignerOrderPhase(Integer orderNo);
	public  DesignerOrderPhaseVO findOneDesignerOrderPhase(Integer orderNo);
	public List<DesignerOrderPhaseVO> getAll();

}
