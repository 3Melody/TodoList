package com.example.NewTodolist.Controller;

import com.example.NewTodolist.AuthenticationRequest;
import com.example.NewTodolist.AuthenticationResponse;
import com.example.NewTodolist.Entity.User;
import com.example.NewTodolist.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.NewTodolist.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
    try {
      System.out.println("Received login request for username: " + authenticationRequest.getUsername());

      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      System.out.println("Incorrect username or password");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
    } catch (Exception e) {
      System.out.println("Login failed: " + e.getMessage());
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Login failed: " + e.getMessage());
    }

    final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);

    User user = userService.findUserByUsername(authenticationRequest.getUsername());

    return ResponseEntity.ok(new AuthenticationResponse(jwt, user.getFirstname(), user.getLastname(), user.getTypeuser()));
  }

}


