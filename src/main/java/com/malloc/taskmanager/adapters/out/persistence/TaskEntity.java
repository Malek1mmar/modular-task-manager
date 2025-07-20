package com.malloc.taskmanager.adapters.out.persistence;

import com.malloc.taskmanager.domain.model.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter @Setter
public class TaskEntity {

  @Id
  private String id;

  private String title;

  private String description;

  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  private Instant createdAt;

  private Instant completedAt;

  public TaskEntity() {
  }

  public TaskEntity(String id, String title, String description, TaskStatus status, Instant createdAt, Instant completedAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }
}