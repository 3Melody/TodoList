package com.example.NewTodolist.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)  // ใส่ nullable = false เพื่อให้ title ต้องไม่เป็นค่าว่าง
    private String title;

    @Column(name = "completed")
    private boolean completed;

<<<<<<< HEAD
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
=======
    // Constructor, Getter และ Setter
    public Task() {
    }
>>>>>>> parent of 775ae1b (DTO Task)

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
}
