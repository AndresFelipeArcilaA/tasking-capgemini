package com.taskingcapgemini.domain.models.enums;

public enum StatusEnum {

	PENDING("PENDING"),
	
	COMPLETED("COMPLETED");
	
	private final String content;
	
	StatusEnum(String content){
		
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
