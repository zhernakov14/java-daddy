package ru.andr.todolistspring.util.mapper;

import org.mapstruct.Mapper;
import ru.andr.todolistspring.entity.Task;
import ru.andr.todolistspring.model.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toTaskDto(Task task);
    Task toTask(TaskDto taskDto);
}

