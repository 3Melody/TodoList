package com.example.NewTodolist.Repository;

import com.example.NewTodolist.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByUserUsername(String username);
}
