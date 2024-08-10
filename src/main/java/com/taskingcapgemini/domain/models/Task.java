package com.taskingcapgemini.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private Long id;

	private String title;

	private String description;

	private String status;

	private LocalDate createdAt;
}
