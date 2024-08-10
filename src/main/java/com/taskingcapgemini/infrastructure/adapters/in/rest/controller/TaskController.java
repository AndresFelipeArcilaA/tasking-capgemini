package com.taskingcapgemini.infrastructure.adapters.in.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskingcapgemini.infrastructure.adapters.in.rest.configuration.TaskApi;
import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.request.TaskRequest;
import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.response.TaskResponse;
import com.taskingcapgemini.infrastructure.adapters.out.database.mappers.TaskMapper;
import com.taskingcapgemini.infrastructure.ports.in.task.TaskUseCase;

@RestController
@RequestMapping("${request-mapping.controller.gestion-tareas}")
@Validated
public class TaskController implements TaskApi {

	@Autowired
	private TaskUseCase useCase;

	@Autowired
	private TaskMapper mapper;

	@Override
	public ResponseEntity<Void> save(TaskRequest request) {

		this.useCase.save(this.mapper.toModel(request));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TaskResponse> findById(Long id) {

		return new ResponseEntity<>(this.mapper.toResponse(this.useCase.findById(id)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TaskResponse>> findAll() {

		return new ResponseEntity<>(this.mapper.toResponse(this.useCase.findAll()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleted(Long id) {
		this.useCase.deleted(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Void> update(TaskRequest request) {
		this.useCase.update(this.mapper.toModel(request));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
