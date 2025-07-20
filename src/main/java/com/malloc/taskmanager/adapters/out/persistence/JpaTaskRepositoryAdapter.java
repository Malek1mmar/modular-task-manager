package com.malloc.taskmanager.adapters.out.persistence;


import com.malloc.taskmanager.application.port.out.TaskRepository;
import com.malloc.taskmanager.domain.model.Task;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepository {

  private final SpringDataTaskRepository springDataTaskRepository;

  private final TaskMapper taskMapper;

  public JpaTaskRepositoryAdapter(SpringDataTaskRepository springDataTaskRepository, TaskMapper taskMapper) {
    this.springDataTaskRepository = springDataTaskRepository;
    this.taskMapper = taskMapper;
  }

  @Override
  public Task save(Task task) {
    springDataTaskRepository.save(taskMapper.toEntity(task));
    return task;
  }

  public Optional<Task> findById(String id) {
    return springDataTaskRepository.findById(id)
        .map(taskMapper::toDomain);
  }

}