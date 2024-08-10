package com.taskingcapgemini.infrastructure.adapters.in.rest.controller.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

	private Long id;

	private String title;

	private String description;

	private String status;

	private LocalDate createdAt;
}
