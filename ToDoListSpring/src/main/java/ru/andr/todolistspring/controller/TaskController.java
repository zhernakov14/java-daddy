package ru.andr.todolistspring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.andr.todolistspring.model.TaskDto;
import ru.andr.todolistspring.service.TaskServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    // Получить все задачи, возможность фильтрации по статусу
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(@RequestParam(required = false) String status) {
        List<TaskDto> tasks = (status == null)
                ? taskService.getAllTasks()
                : taskService.getTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    // Создать новую задачу
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Получить задачу по id
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        TaskDto task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    // Обновить задачу (редактировать)
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(updatedTask);
    }

    // Удалить задачу
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Сортировка по сроку
    @GetMapping("/sort")
    public ResponseEntity<List<TaskDto>> getSortedTasks(@RequestParam String parameter) {
        List<TaskDto> sortedTasks = taskService.sort(parameter);
        return ResponseEntity.ok(sortedTasks);
    }
}
