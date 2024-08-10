package com.taskingcapgemini.infrastructure.adapters.out.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskingcapgemini.infrastructure.adapters.out.database.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}
