package com.malloc.taskmanager.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, String> {
}
