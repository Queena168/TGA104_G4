package com.expertise.model;

public class ExpertiseVO implements java.io.Serializable {
	private Integer expertiseNo;// (專長編號): int, not null
	private String expertiseName;// (專長名稱): varchar(25), not null



	public Integer getExpertiseNo() {
		return expertiseNo;
	}

	public void setExpertiseNo(Integer expertiseNo) {
		this.expertiseNo = expertiseNo;
	}

	public String getExpertiseName() {
		return expertiseName;
	}

	public void setExpertiseName(String expertiseName) {
		this.expertiseName = expertiseName;
	}

}
