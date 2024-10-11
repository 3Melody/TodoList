package com.example.NewTodolist.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title", nullable = false)
  private String title;

<<<<<<< HEAD
  @Column(name = "completed")
  private boolean completed;
=======
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

    // Constructor, Getter และ Setter
    public Task() {
    }
>>>>>>> parent of 89ea2c2 (Revert "add login pages")

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // ป้องกันการโหลดแบบ Lazy
  private User user;

  // Constructor, Getter และ Setter
  public Task() {}

  public Task(String title, boolean completed) {
    this.title = title;
    this.completed = completed;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
