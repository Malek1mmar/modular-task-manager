package com.malloc.taskmanager.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
  private final TaskId id;
  private String title;
  private String description;
  private TaskStatus status;
  private final LocalDateTime createdAt;

  public Task(TaskId id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = TaskStatus.TODO;
    this.createdAt = LocalDateTime.now();
  }
  public Task(TaskId id, String title, String description, TaskStatus status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.createdAt = LocalDateTime.now();
  }

  public TaskId getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void start() {
    if (status == TaskStatus.TODO) {
      this.status = TaskStatus.IN_PROGRESS;
    }
  }

  public void complete() {
    if (status == TaskStatus.IN_PROGRESS) {
      this.status = TaskStatus.DONE;
    }
  }

  public void rename(String newTitle) {
    this.title = newTitle;
  }

  public void updateDescription(String newDescription) {
    this.description = newDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Task task)) return false;
    return Objects.equals(id, task.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}