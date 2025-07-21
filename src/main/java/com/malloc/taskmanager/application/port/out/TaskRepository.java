package com.malloc.taskmanager.application.port.out;

import com.malloc.taskmanager.domain.model.Task;
import java.util.Optional;

public interface TaskRepository {
  Task save(Task task);
  Optional<Task> findById(String id);
}