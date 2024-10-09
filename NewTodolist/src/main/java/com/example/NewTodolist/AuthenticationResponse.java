package com.example.NewTodolist;

public class AuthenticationResponse {
  private String jwt;
  private String firstname;
  private String lastname;
  private String typeuser;

  // Constructor สำหรับการรับค่าเริ่มต้น
  public AuthenticationResponse(String jwt, String firstname, String lastname, String typeuser) {
    this.jwt = jwt;
    this.firstname = firstname;
    this.lastname = lastname;
    this.typeuser = typeuser;
  }

  // สร้าง Getter สำหรับข้อมูล
  public String getJwt() {
    return jwt;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getTypeuser() {
    return typeuser;
  }
}

