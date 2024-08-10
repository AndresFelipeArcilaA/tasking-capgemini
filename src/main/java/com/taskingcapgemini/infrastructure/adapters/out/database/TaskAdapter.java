package com.taskingcapgemini.infrastructure.adapters.out.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskingcapgemini.application.exception.TaskDeletionException;
import com.taskingcapgemini.application.exception.TaskNotFoundException;
import com.taskingcapgemini.domain.models.Task;
import com.taskingcapgemini.infrastructure.adapters.out.database.mappers.TaskMapper;
import com.taskingcapgemini.infrastructure.adapters.out.database.repository.TaskRepository;
import com.taskingcapgemini.infrastructure.ports.out.TaskPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskAdapter implements TaskPort {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private TaskMapper mapper;

	@Override
	public Task save(Task task) {
		return this.mapper.toModel(this.repository.saveAndFlush(this.mapper.toEntity(task)));
	}

	@Override
	public Task findById(Long id) {
		return this.repository.findById(id)
				.map(this.mapper::toModel)
				.orElseThrow(() -> new TaskNotFoundException(id));
	}

	@Override
	public List<Task> findAll() {
		return this.mapper.toModel(this.repository.findAll());
	}

	@Override
	public void deleted(Long id) {
		try {
			this.findById(id);
			this.repository.deleteById(id);
		} catch (Exception e) {
			throw new TaskDeletionException(id);
		}
	}
}
