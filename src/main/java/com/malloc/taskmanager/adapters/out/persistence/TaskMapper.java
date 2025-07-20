package com.malloc.taskmanager.adapters.out.persistence;


import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import com.malloc.taskmanager.domain.model.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

  public TaskEntity toEntity(Task task) {
    return new TaskEntity(
        task.getId().toString(),
        task.getTitle(),
        task.getDescription(),
        task.getStatus(),
        null, null
    );
  }

  public Task toDomain(TaskEntity entity) {
    return new Task(
        new TaskId(entity.getId()),
        entity.getTitle(),
        entity.getDescription(),
        TaskStatus.valueOf(String.valueOf(entity.getStatus()))
    );
  }
}
