package com.malloc.taskmanager.domain.model;

import java.util.Objects;
import java.util.UUID;

public class TaskId {
  private final String value;

  public TaskId() {
    this.value = UUID.randomUUID().toString();
  }

  public TaskId(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TaskId taskId)) return false;
    return Objects.equals(value, taskId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
