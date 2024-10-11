package com.example.NewTodolist.Controller;

import com.example.NewTodolist.DTO.TaskDTO;
import com.example.NewTodolist.Entity.Task;
import com.example.NewTodolist.Repository.TaskRepository;
import com.example.NewTodolist.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;



import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public List<TaskDTO> getAllTasks() {
    return taskService.getAllTasks();  // ส่ง TaskDTO กลับไป
  }

<<<<<<< HEAD
  @GetMapping("/user/{userId}")
  public List<TaskDTO> getTasksByUserId(@PathVariable Long userId) {
    return taskService.getTasksByUserId(userId);
  }
  @GetMapping("/my-tasks")
  public List<TaskDTO> getMyTasks(Authentication authentication) {
    String username = authentication.getName();
    // คุณอาจต้องหา userId จาก username ก่อน หรือปรับให้ใช้ userId ตรงๆ
    Long userId = Long.valueOf(username);  // สมมติว่า username เป็น userId
    return taskService.getTasksByUserId(userId);
  }
=======
  @Autowired
  private TaskRepository taskRepository;

  @GetMapping("/my-tasks")
  public List<Task> getMyTasks(Authentication authentication) {
    // ตรวจสอบว่า Authentication ไม่เป็น null และดึง username
    String username = authentication.getName();
    return taskRepository.findByUserUsername(username);
  }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
    }
>>>>>>> parent of 89ea2c2 (Revert "add login pages")

  @GetMapping("/{id}")
  public ResponseEntity<?> getTaskById(@PathVariable int id) {
    Optional<Task> task = taskService.getTaskById(id);
    if (task.isPresent()) {
      return ResponseEntity.ok(task.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }
  }

  @PostMapping
  public Task addTask(@RequestBody Task task) {
    return taskService.addTask(task);
  }

  @PutMapping("/{id}")
  public Task updateTask(@PathVariable int id, @RequestBody Task task) {
    task.setId(id);  // กำหนด ID ให้กับ task ก่อนการอัพเดท
    return taskService.updateTask(task);
  }

  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable int id) {
    taskService.deleteTask(id);
  }
}
