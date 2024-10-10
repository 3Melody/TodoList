package com.example.NewTodolist.Repository;

import com.example.NewTodolist.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    // JpaRepository มี method ในการค้นหาตาม ID อยู่แล้ว
}
