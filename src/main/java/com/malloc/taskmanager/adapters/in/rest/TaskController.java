package com.malloc.taskmanager.adapters.in.rest;


import com.malloc.taskmanager.adapters.in.rest.dto.CreateTaskRequest;
import com.malloc.taskmanager.adapters.in.rest.dto.TaskResponse;
import com.malloc.taskmanager.application.port.in.CreateTaskUseCase;
import com.malloc.taskmanager.application.port.in.TaskUseCase;
import com.malloc.taskmanager.application.port.in.command.CreateTaskCommand;
import com.malloc.taskmanager.domain.model.Task;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskUseCase taskUseCase;
  private final CreateTaskUseCase createTaskService;

  public TaskController(TaskUseCase taskUseCase,
                        CreateTaskUseCase createTaskService) {
    this.taskUseCase = taskUseCase;
    this.createTaskService = createTaskService;
  }

  @PostMapping
  public ResponseEntity<Void> createTask(@RequestBody CreateTaskRequest request) {
    createTaskService.createTask(new CreateTaskCommand(
        request.title(),
        request.description()
    ));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskResponse> getTask(@PathVariable String id) {
    Optional<Task> task = taskUseCase.getTaskById(id);
    return task
        .map(t -> ResponseEntity.ok(new TaskResponse(
            t.getId().getValue(),
            t.getTitle(),
            t.getDescription(),
            t.getStatus().name())))
        .orElse(ResponseEntity.notFound().build());
  }
}