package com.malloc.taskmanager.application.service;

import com.malloc.taskmanager.application.port.in.TaskUseCase;
import com.malloc.taskmanager.application.port.out.TaskRepository;
import com.malloc.taskmanager.domain.model.Task;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskUseCase {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void createTask(Task task) {
    taskRepository.save(task);
  }

  @Override
  public Optional<Task> getTaskById(String id) {
    return taskRepository.findById(id);
  }
}