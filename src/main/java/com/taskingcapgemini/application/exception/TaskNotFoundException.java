package com.taskingcapgemini.application.exception;

public class TaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2475863539121533779L;

	public TaskNotFoundException(Long id) {
        super("No existe ninguna tarea con el id : " + id);
    }
}
