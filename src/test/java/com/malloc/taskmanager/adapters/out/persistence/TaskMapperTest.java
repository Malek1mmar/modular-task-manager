package com.malloc.taskmanager.adapters.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import org.junit.jupiter.api.Test;

class TaskMapperTest {

  private final TaskMapper mapper = new TaskMapper();

  @Test
  void shouldMapDomainToEntityAndBack() {
    Task task = new Task(
        new TaskId("abc123"),
        "title",
        "desc"
    );

    TaskEntity entity = mapper.toEntity(task);
    Task mappedBack = mapper.toDomain(entity);

    assertThat(entity.getId()).isEqualTo("abc123");
    assertThat(mappedBack.getTitle()).isEqualTo("title");
    assertThat(mappedBack.getDescription()).isEqualTo("desc");
    assertThat(mappedBack.getId().getValue()).isEqualTo("abc123");
  }
}