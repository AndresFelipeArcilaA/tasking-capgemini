package com.taskingcapgemini.application.exception;

public class TaskElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4902284848309893321L;

	public TaskElementNotFoundException(String atribute) {
        super(atribute);
    }
}
