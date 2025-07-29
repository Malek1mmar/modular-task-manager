package com.malloc.taskmanager.application.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.malloc.taskmanager.application.port.in.command.CreateTaskCommand;
import com.malloc.taskmanager.application.port.out.TaskRepository;
import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class CreateTaskServiceTest {

  private TaskRepository taskRepository;
  private CreateTaskService createTaskService;

  @BeforeEach
  void setUp() {
    taskRepository = mock(TaskRepository.class);
    createTaskService = new CreateTaskService(taskRepository);
  }

  @Test
  void shouldCreateTaskAndPersistIt() {
    // Given
    CreateTaskCommand command = new CreateTaskCommand(
        "Learn Hexagonal Architecture",
        "Start small and iterate"
    );
    when(taskRepository.save(any(Task.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));
    // When
    Task returnedTask = createTaskService.createTask(command);

    // Then
    ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
    verify(taskRepository).save(taskCaptor.capture());

    Task capturedTask = taskCaptor.getValue();

    assertThat(capturedTask.getTitle()).isEqualTo(command.title());
    assertThat(capturedTask.getStatus()).isEqualTo(TaskStatus.TODO);
    assertThat(capturedTask.getId()).isNotNull();
    assertThat(returnedTask.getTitle()).isEqualTo(command.title());
  }
}