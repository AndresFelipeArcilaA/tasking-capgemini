package com.taskingcapgemini.infrastructure.adapters.in.rest.configuration;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.request.TaskRequest;
import com.taskingcapgemini.infrastructure.adapters.in.rest.controller.response.TaskResponse;

public interface TaskApi {

	@PostMapping
	ResponseEntity<Void> save (@RequestBody TaskRequest request);
	
	@PutMapping
	ResponseEntity<Void> update(@RequestBody TaskRequest request);
	
	@GetMapping
	ResponseEntity<TaskResponse> findById (Long id);
	
	@GetMapping("/tareas")
	ResponseEntity<List<TaskResponse>> findAll ();
	
	@DeleteMapping()
	ResponseEntity<Void> deleted (Long id);
}
