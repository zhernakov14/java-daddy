package ru.andr.javadaddy.advanced.javatodolist.service;

import lombok.AllArgsConstructor;
import ru.andr.javadaddy.advanced.javatodolist.entity.Task;
import ru.andr.javadaddy.advanced.javatodolist.repository.TaskRepository;
import ru.andr.javadaddy.advanced.javatodolist.util.TaskStatus;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task addTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(UUID.randomUUID(), title, description, dueDate, TaskStatus.TODO);
        taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> editTask(UUID id, String newTitle, String newDescription, LocalDate newDueDate, TaskStatus newStatus) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        optionalTask.ifPresent(task -> {
            task.setName(newTitle);
            task.setDescription(newDescription);
            task.setDueDate(newDueDate);
            task.setStatus(newStatus);
            taskRepository.save(task);
        });
        return optionalTask;
    }

    public boolean deleteTask(UUID id) {
        return taskRepository.deleteById(id);
    }

    public List<Task> filterTasksByStatus(TaskStatus status) {
        return taskRepository.findAll().stream()
                .filter(task -> Objects.equals(task.getStatus(), status))
                .toList();
    }

    public List<Task> sortTasksByDueDate() {
        return taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }

    public List<Task> sortTasksByStatus() {
        return taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getStatus))
                .toList();
    }

    public Optional<Task> getTask(UUID id) {
        return taskRepository.findById(id);
    }

}
