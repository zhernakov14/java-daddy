package ru.andr.todolistspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andr.todolistspring.entity.Task;
import ru.andr.todolistspring.util.enums.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
