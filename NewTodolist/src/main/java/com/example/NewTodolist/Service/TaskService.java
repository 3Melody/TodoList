package com.example.NewTodolist.Service;


import com.example.NewTodolist.DTO.TaskDTO;
import com.example.NewTodolist.Entity.Task;
import com.example.NewTodolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

  public List<TaskDTO> getAllTasks() {
    return taskRepository.findAll().stream()
      .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.isCompleted(), task.getUser().getId()))
      .collect(Collectors.toList());
  }

  public List<TaskDTO> getTasksByUserId(Long userId) {
    return taskRepository.findByUserId(userId).stream()
      .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.isCompleted(), task.getUser().getId()))
      .collect(Collectors.toList());
  }





  public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
