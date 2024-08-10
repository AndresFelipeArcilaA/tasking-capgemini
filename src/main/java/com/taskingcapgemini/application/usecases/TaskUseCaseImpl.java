package com.taskingcapgemini.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskingcapgemini.application.exception.TaskElementNotFoundException;
import com.taskingcapgemini.domain.models.Task;
import com.taskingcapgemini.domain.models.enums.MessagesErrorEnum;
import com.taskingcapgemini.domain.models.enums.StatusEnum;
import com.taskingcapgemini.infrastructure.ports.in.task.TaskUseCase;
import com.taskingcapgemini.infrastructure.ports.out.TaskPort;

@Service
public class TaskUseCaseImpl implements TaskUseCase {

	@Autowired
	private TaskPort adapter;

	@Override
	public void save(Task task) {

		if (task.getTitle() == null) {
			throw new TaskElementNotFoundException(MessagesErrorEnum.TITLE_REQUIRED.getContent());
		}

		if (task.getStatus() == null) {
			throw new TaskElementNotFoundException(MessagesErrorEnum.STATUS_REQUIRED.getContent());
		}

		if (task.getCreatedAt() == null) {
			throw new TaskElementNotFoundException(MessagesErrorEnum.CREATEDAT_REQUIRED.getContent());
		}
		
		task.setStatus(task.getStatus().toUpperCase());
		if(!task.getStatus().equals(StatusEnum.COMPLETED.getContent()) && !task.getStatus().equals(StatusEnum.PENDING.getContent())) {
			throw new TaskElementNotFoundException(MessagesErrorEnum.STATUS_ERROR.getContent());
		}
		

		this.adapter.save(task);

	}

	@Override
	public void update(Task task) {

		Task taskUpdate = this.findById(task.getId());

		if (task.getTitle() != null) {
			taskUpdate.setTitle(task.getTitle());
		}
		if (task.getDescription() != null) {
			taskUpdate.setDescription(task.getDescription());
		}
		if (task.getCreatedAt() != null) {
			taskUpdate.setCreatedAt(task.getCreatedAt());
		}
		if (task.getStatus() != null) {
			taskUpdate.setStatus(task.getStatus());
		}
		
		this.save(taskUpdate);

	}

	@Override
	public void deleted(Long id) {
		this.adapter.deleted(id);

	}

	@Override
	public Task findById(Long id) {

		return this.adapter.findById(id);
	}

	@Override
	public List<Task> findAll() {

		return this.adapter.findAll();
	}

}
