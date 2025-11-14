package ru.andr.todolistspring.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.andr.todolistspring.util.enums.TaskStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @FutureOrPresent
    private LocalDate dueDate;

    private TaskStatus status;
}
