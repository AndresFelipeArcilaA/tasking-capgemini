package com.taskingcapgemini.infrastructure.ports.in.task;

import java.util.List;

import com.taskingcapgemini.domain.models.Task;

public interface TaskUseCase {

	void save(Task task);
	
	void update(Task task);
	
	void deleted(Long id);
	
	Task findById(Long id);
	
	List<Task> findAll();
}
