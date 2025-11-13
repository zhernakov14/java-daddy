package ru.andr.todolistspring.service.impl;

import ru.andr.todolistspring.model.TaskDto;

import java.util.List;

public interface TaskService {

    // Получить все задачи
    List<TaskDto> getAllTasks();

    // Получить задачи по статусу
    List<TaskDto> getTasksByStatus(String status);

    // Получить задачу по id, выбросить исключение, если не найдена
    TaskDto getTaskById(Long id);

    // Создать новую задачу
    TaskDto createTask(TaskDto taskDto);

    // Обновить существующую задачу
    TaskDto updateTask(Long id, TaskDto taskDto);

    // Удалить задачу по id
    void deleteTask(Long id);

    // Сортировка
    List<TaskDto> sort(String parameter);
}
