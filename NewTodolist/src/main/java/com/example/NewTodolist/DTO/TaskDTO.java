package com.example.NewTodolist.DTO;

public class TaskDTO {

  private int id;
  private String title;
  private boolean completed;
  private Long userId;  // ใส่ userId แทนที่ User

  public TaskDTO(int id, String title, boolean completed, Long userId) {
    this.id = id;
    this.title = title;
    this.completed = completed;
    this.userId = userId;
  }

  // Getters และ Setters
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
