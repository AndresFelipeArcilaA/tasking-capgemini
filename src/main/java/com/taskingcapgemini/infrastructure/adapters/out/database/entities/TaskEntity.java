package com.taskingcapgemini.infrastructure.adapters.out.database.entities;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TASK")
@Entity
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "NUMBER(6,0)", nullable = false)
	private Long id;
	
	@Column(name = "TITLE", columnDefinition = "VARCHAR2(22)", nullable = false)
	private String title;
	
	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(55)", nullable = true)
	private String description;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR(9)", nullable = false)
	@Comment("El estado solo puede ser 'PENDING' o 'COMPLETED'")
	private String status;
	
	@Column(name = "CREATEDAT", columnDefinition = "DATE", nullable = false)
	private LocalDate createdAt;
	
}
