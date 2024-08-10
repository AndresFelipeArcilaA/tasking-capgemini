package com.taskingcapgemini.infrastructure.ports.out;

import java.util.List;

import com.taskingcapgemini.domain.models.Task;

public interface TaskPort {

	Task save(Task task);
	
	void deleted(Long id);
	
	Task findById(Long id);
	
	List<Task> findAll();
}
