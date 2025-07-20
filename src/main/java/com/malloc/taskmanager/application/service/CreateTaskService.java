package com.malloc.taskmanager.application.service;


import com.malloc.taskmanager.application.port.in.CreateTaskUseCase;
import com.malloc.taskmanager.application.port.in.command.CreateTaskCommand;
import com.malloc.taskmanager.application.port.out.TaskRepository;
import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import java.time.Instant;

public class CreateTaskService implements CreateTaskUseCase {

  private final TaskRepository taskRepository;

  public CreateTaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public Task createTask(CreateTaskCommand command) {
    Task task = new Task(
        new TaskId(),
        command.title(),
        command.description()
    );

    return taskRepository.save(task);
  }
}