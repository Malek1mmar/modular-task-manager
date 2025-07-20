package com.malloc.taskmanager.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TaskTest {

  @Test
  void task_is_created_with_todo_status() {
    Task task = new Task(new TaskId(), "Test", "Start the test");

    assertEquals(TaskStatus.TODO, task.getStatus());
    assertNotNull(task.getCreatedAt());
    assertNotNull(task.getId());
    assertEquals("Test", task.getTitle());
    assertEquals("Start the test", task.getDescription());
  }

  @Test
  void task_can_be_started_from_todo() {
    Task task = new Task(new TaskId(), "Start me", "Test");

    task.start();

    assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
  }

  @Test
  void task_does_not_change_status_if_started_twice() {
    Task task = new Task(new TaskId(), "Double start", "Test");

    task.start();
    task.start();

    assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
  }

  @Test
  void task_can_be_completed_only_from_in_progress() {
    Task task = new Task(new TaskId(), "Complete me", "Test");

    task.start();
    task.complete();

    assertEquals(TaskStatus.DONE, task.getStatus());
  }

  @Test
  void task_does_not_complete_directly_from_todo() {
    Task task = new Task(new TaskId(), "Skip step", "Test");

    task.complete();

    assertEquals(TaskStatus.TODO, task.getStatus());
  }

  @Test
  void task_can_be_renamed() {
    Task task = new Task(new TaskId(), "Old title", "Test");

    task.rename("New title");

    assertEquals("New title", task.getTitle());
  }

  @Test
  void task_can_update_description() {
    Task task = new Task(new TaskId(), "Task", "Old description");

    task.updateDescription("New description");

    assertEquals("New description", task.getDescription());
  }

  @Test
  void task_equality_is_based_on_id() {

    TaskId id = new TaskId("same-id");
    Task task1 = new Task(id, "Task 1", "Desc");
    Task task2 = new Task(id, "Task 2", "Another desc");

    assertEquals(task1, task2);
  }
}