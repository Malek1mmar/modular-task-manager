package com.malloc.taskmanager.adapters.out.persistence;


import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

  public TaskEntity toEntity(Task task) {
    TaskEntity entity = new TaskEntity();
    entity.setId(task.getId() != null ? task.getId().getValue() : null);
    entity.setTitle(task.getTitle());
    entity.setDescription(task.getDescription());
    entity.setStatus(task.getStatus());
    return entity;
  }

  public Task toDomain(TaskEntity entity) {
    return new Task(
        new TaskId(entity.getId()),
        entity.getTitle(),
        entity.getDescription(),
        entity.getStatus()
    );
  }
}