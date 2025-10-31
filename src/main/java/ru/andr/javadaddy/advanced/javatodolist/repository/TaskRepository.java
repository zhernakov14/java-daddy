package ru.andr.javadaddy.advanced.javatodolist.repository;

import ru.andr.javadaddy.advanced.javatodolist.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private long currentId = 0;

    // Добавить задачу
    public void save(Task task) {
        if (task.getId() == null) {
            task.setId(++currentId);
        }
        tasks.put(task.getId(), task);
    }

    // Найти задачу по id
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    // Получить все задачи
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    // Удалить задачу по id, вернуть true если успешно
    public boolean deleteById(Long id) {
        return tasks.remove(id) != null;
    }
}
