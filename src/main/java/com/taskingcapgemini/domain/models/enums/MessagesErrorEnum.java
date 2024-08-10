package com.taskingcapgemini.domain.models.enums;

public enum MessagesErrorEnum {

	TITLE_REQUIRED("El atributo title es requerido"),
	STATUS_REQUIRED("El atributo status es requerido"),
	CREATEDAT_REQUIRED("El atributo RequiredAt es requerido"),
	STATUS_ERROR("El estado debe ser 'PENDING' o 'COMPLETED'");
	
	private final String content;
	
	MessagesErrorEnum(String content){
		
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
