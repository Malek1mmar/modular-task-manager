package com.malloc.taskmanager.application.port.in;

import com.malloc.taskmanager.domain.model.Task;
import java.util.Optional;

public interface TaskUseCase {
  void createTask(Task task);
  Optional<Task> getTaskById(String id);
}