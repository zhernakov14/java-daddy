package ru.andr.javadaddy.advanced.javatodolist.repository;

import ru.andr.javadaddy.advanced.javatodolist.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TaskRepository {

    private final Map<UUID, Task> tasks = new HashMap<>();

    // Добавить задачу
    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    // Найти задачу по id
    public Optional<Task> findById(UUID id) {
        return Optional.ofNullable(tasks.get(id));
    }

    // Получить все задачи
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    // Удалить задачу по id, вернуть true если успешно
    public boolean deleteById(UUID id) {
        return tasks.remove(id) != null;
    }

    // Проверить наличие задачи по id
    public boolean existsById(UUID id) {
        return tasks.containsKey(id);
    }
}
