package com.example.NewTodolist.Repository;

import com.example.NewTodolist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}

