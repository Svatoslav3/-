package com.example.demo.Service;

import com.example.demo.Exeptions.ResourceNotFoundException;
import com.example.demo.Repository.Repository;
import com.example.demo.model.Models;
import com.example.demo.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private Repository.TaskRepository taskRepository;

    // Метод для получения всех продуктов
    public List<Models.Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Метод для сохранения нового продукта
    public Models.Task createTask(Models.Task task) {
        return taskRepository.save(task);
    }

    // Метод для обновления существующего продукта
    public Models.Task updateTask(Long id, Models.Task taskDetails) {
        Models.Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        task.setName(taskDetails.getName());
        task.setShortDescription(taskDetails.getShortDescription());
        task.setDescription(taskDetails.getDescription());
        task.setServiceLink(taskDetails.getServiceLink());
        task.setContacts(taskDetails.getContacts());
        task.setStatus(taskDetails.getStatus());

        return taskRepository.save(task);
    }

    // Метод для отправки продукта на модерацию
    public Models.Task submitForModeration(Long id) {
        Models.Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        // Предположим, что статус "На модерации" имеет статус ID 2
        task.setStatus(new Status(2L, "На модерации"));
        return taskRepository.save(task);
    }

    // Метод для одобрения продукта
    public Models.Task approveTask(Long id) {
        Models.Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        // Предположим, что статус "Опубликован" имеет статус ID 1
        task.setStatus(new Status(1L, "Опубликован"));
        return taskRepository.save(task);
    }

    // Метод для отклонения продукта
    public Models.Task rejectTask(Long id) {
        Models.Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        // Предположим, что статус "Отклонен" имеет статус ID 3
        task.setStatus(new Status(3L, "Отклонен"));
        return taskRepository.save(task);
    }
}
