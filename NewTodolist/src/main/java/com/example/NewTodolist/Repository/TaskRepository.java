package com.example.NewTodolist.Repository;

import com.example.NewTodolist.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

<<<<<<< HEAD
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByUserId(Long userId);
=======
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findByUserUsername(String username);
>>>>>>> parent of 89ea2c2 (Revert "add login pages")
}

