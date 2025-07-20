package com.malloc.taskmanager.application.port.out;

import com.malloc.taskmanager.domain.model.Task;

public interface TaskRepository {
  Task save(Task task);
}