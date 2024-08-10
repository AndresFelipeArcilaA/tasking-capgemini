package com.taskingcapgemini.infrastructure.adapters.out.database.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.taskingcapgemini.domain.models.Task;
import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.request.TaskRequest;
import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.response.TaskResponse;
import com.taskingcapgemini.infrastructure.adapters.out.database.entities.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {

	Task toModel(TaskEntity taskEntity);

	TaskEntity toEntity(Task task);

	Task toModel(TaskRequest taskRequest);

	TaskResponse toResponse(Task task);

	List<Task> toModel(List<TaskEntity> taskEntity);
	
	List<TaskResponse> toResponse(List<Task> task);

}
