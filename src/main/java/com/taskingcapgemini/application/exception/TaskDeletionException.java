package com.taskingcapgemini.application.exception;

public class TaskDeletionException extends RuntimeException {

	private static final long serialVersionUID = -4902284848309893321L;

	public TaskDeletionException(Long id) {
        super("No se puede eliminar el id: " + id + " porque no existe");
    }
}
