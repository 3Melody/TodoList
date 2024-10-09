package com.example.NewTodolist;

public class AuthenticationRequest {
  private String username;
  private String password;

  // สร้าง Getter และ Setter สำหรับข้อมูล username และ password
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
}
