package com.malloc.taskmanager.adapters.in.rest;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.malloc.taskmanager.application.port.in.CreateTaskUseCase;
import com.malloc.taskmanager.application.port.in.TaskUseCase;
import com.malloc.taskmanager.domain.model.Task;
import com.malloc.taskmanager.domain.model.TaskId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = TaskController.class)
class TaskControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private CreateTaskUseCase createTaskUseCase;
  @MockitoBean
  private TaskUseCase taskUseCase;
  @Test
  void shouldCreateTaskViaHttpPost() throws Exception {

    Task task = new Task(new TaskId("xyz"), "test title", "desc");

    when(createTaskUseCase.createTask(any())).thenReturn(task);
    mockMvc.perform(
            MockMvcRequestBuilders.post("/tasks")
                .content("""
                      {
                        "title": "test title",
                        "description": "desc"
                      }
                  """)
                .contentType(APPLICATION_JSON)
                .characterEncoding(UTF_8.toString()))
        .andExpect(status().isCreated());
  }
}