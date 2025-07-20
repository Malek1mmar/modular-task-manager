package com.malloc.taskmanager.application.port.in;

import com.malloc.taskmanager.application.port.in.command.CreateTaskCommand;
import com.malloc.taskmanager.domain.model.Task;

public interface CreateTaskUseCase {
  Task createTask(CreateTaskCommand command);
}
