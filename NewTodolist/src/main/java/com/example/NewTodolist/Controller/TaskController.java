package com.example.NewTodolist.Controller;

import com.example.NewTodolist.Entity.Task;
import com.example.NewTodolist.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
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

