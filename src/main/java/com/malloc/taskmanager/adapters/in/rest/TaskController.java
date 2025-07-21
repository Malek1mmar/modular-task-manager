package com.malloc.taskmanager.adapters.in.rest;


import com.malloc.taskmanager.adapters.in.rest.dto.CreateTaskRequest;
import com.malloc.taskmanager.adapters.in.rest.dto.TaskResponse;
import com.malloc.taskmanager.application.port.in.TaskUseCase;
import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import com.malloc.taskmanager.domain.model.TaskStatus;
import java.util.Optional;
import java.util.UUID;
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

  public TaskController(TaskUseCase taskUseCase) {
    this.taskUseCase = taskUseCase;
  }

  @PostMapping
  public ResponseEntity<Void> createTask(@RequestBody CreateTaskRequest request) {
    Task task = new Task(
        new TaskId(UUID.randomUUID().toString()),
        request.title(),
        request.description(),
        TaskStatus.TODO
    );
    taskUseCase.createTask(task);
    return ResponseEntity.ok().build();
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