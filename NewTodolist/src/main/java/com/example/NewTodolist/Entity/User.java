package com.example.NewTodolist.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")  // กำหนดชื่อของตาราง
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  private String firstname;
  private String lastname;
  private String typeuser;

  // ความสัมพันธ์กับ Task
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Task> tasks = new ArrayList<>();

  // Getters and Setters
  // (รวม Getter และ Setter ของ Task ด้วย)

  public Long getId() {
    return id;
  }

  public class User {
    this.typeuser = typeuser;
  }

  public List<Task> getTasks() {
    return tasks;
  }


  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
}
