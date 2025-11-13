package ru.andr.todolistspring.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    @NotNull
    private String name;

    private String description;

    private LocalDate dueDate;

    private String status;
}
