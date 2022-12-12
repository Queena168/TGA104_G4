package com.designer.model;

import com.designer.service.DesignerService;
import com.designer.service.ExpertiseService;

public class DesignerExpertiseVO {
	private Integer designerExpertiseNo;// (設計師專長編號): int, not null
	private Integer designerNo;// (設計師編號): int,
	private Integer expertiseNo;// (專長編號): int,

	public Integer getDesignerExpertiseNo() {
		return designerExpertiseNo;
	}

	public void setDesignerExpertiseNo(Integer designerExpertiseNo) {
		this.designerExpertiseNo = designerExpertiseNo;
	}

	public Integer getDesignerNo() {
		return designerNo;
	}

	public void setDesignerNo(Integer designerNo) {
		this.designerNo = designerNo;
	}

	public Integer getExpertiseNo() {
		return expertiseNo;
	}

	public void setExpertiseNo(Integer expertiseNo) {
		this.expertiseNo = expertiseNo;
	}
	
	//======================================================
	   //designer
		public DesignerVO getDesignerVO() {
			DesignerService designerSvc = new DesignerService();
			DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);
			return designerVO;

		}
		
   //==========================================================
		//expertise
		public ExpertiseVO getExpertiseVO() {
			ExpertiseService expertiseSvc = new ExpertiseService();
			ExpertiseVO expertiseVO = expertiseSvc.getOneExpertise(expertiseNo);
			return expertiseVO;
		}
	
}
