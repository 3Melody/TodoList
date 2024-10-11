package com.example.NewTodolist.Entity;

<<<<<<< HEAD
import jakarta.persistence.*;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======

import java.util.ArrayList;
import java.util.List;


>>>>>>> parent of 89ea2c2 (Revert "add login pages")
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
>>>>>>> parent of 775ae1b (DTO Task)

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Task> tasks = new ArrayList<>();

>>>>>>> parent of 89ea2c2 (Revert "add login pages")

=======
>>>>>>> parent of 775ae1b (DTO Task)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getTypeuser() {
    return typeuser;
  }

  public void setTypeuser(String typeuser) {
    this.typeuser = typeuser;
  }

  private String password;
  private String firstname;
  private String lastname;
  private String typeuser;

  // Getters and Setters
}
