package ru.andr.javadaddy.advanced.javatodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.andr.javadaddy.advanced.javatodolist.util.TaskStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Task {

    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
}
