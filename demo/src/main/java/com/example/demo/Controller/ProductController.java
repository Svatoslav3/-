package com.example.demo.Controller;

import com.example.demo.Service.TaskService;
import com.example.demo.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private TaskService taskService;

    // Получение списка всех продуктов
    @GetMapping
    public List<Models.Task> getAllProducts() {
        return taskService.getAllTasks();
    }

    // Создание нового продукта
    @PostMapping
    public ResponseEntity<Models.Task> createProduct(@RequestBody Models.Task task) {
        Models.Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Обновление существующего продукта
    @PutMapping("/{id}")
    public ResponseEntity<Models.Task> updateProduct(@PathVariable Long id, @RequestBody Models.Task taskDetails) {
        Models.Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    // Отправка продукта на модерацию
    @PutMapping("/{id}/submit")
    public ResponseEntity<Models.Task> submitProductForModeration(@PathVariable Long id) {
        Models.Task task = taskService.submitForModeration(id);
        return ResponseEntity.ok(task);
    }

    // Одобрение продукта
    @PutMapping("/{id}/approve")
    public ResponseEntity<Models.Task> approveProduct(@PathVariable Long id) {
        Models.Task task = taskService.approveTask(id);
        return ResponseEntity.ok(task);
    }

    // Отклонение продукта
    @PutMapping("/{id}/reject")
    public ResponseEntity<Models.Task> rejectProduct(@PathVariable Long id) {
        Models.Task task = taskService.rejectTask(id);
        return ResponseEntity.ok(task);
    }
}
