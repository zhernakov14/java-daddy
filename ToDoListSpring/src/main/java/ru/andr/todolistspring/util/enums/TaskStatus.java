package ru.andr.todolistspring.util.enums;


import ru.andr.todolistspring.util.exception.TaskStatusException;

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;

    public static TaskStatus getTaskStatus(final String status) {
        if (status == null) {
            throw new TaskStatusException();
        }
        try {
            return TaskStatus.valueOf(status.toUpperCase());
        } catch (Exception e) {
            throw new TaskStatusException();
        }
    }
}
