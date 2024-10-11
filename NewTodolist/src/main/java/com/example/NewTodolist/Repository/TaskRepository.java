package com.example.NewTodolist.Repository;

import com.example.NewTodolist.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByUserId(Long userId);
}

