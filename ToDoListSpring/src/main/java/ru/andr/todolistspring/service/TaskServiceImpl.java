package ru.andr.todolistspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andr.todolistspring.entity.Task;
import ru.andr.todolistspring.model.TaskDto;
import ru.andr.todolistspring.repository.TaskRepository;
import ru.andr.todolistspring.service.impl.TaskService;
import ru.andr.todolistspring.util.enums.TaskStatus;
import ru.andr.todolistspring.util.mapper.TaskMapper;

import java.util.Comparator;
import java.util.List;

import static ru.andr.todolistspring.util.enums.TaskStatus.getTaskStatus;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private final String TASK_NOT_FOUND = "Задача не найдена: %d";
    private final String WRONG_SORT_PARAMETER = "Укажите один из двух параметров сортировки: date или status";
    private final String SORT_PARAMETER_DATE = "date";
    private final String SORT_PARAMETER_STATUS = "status";

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public List<TaskDto> getTasksByStatus(String status) {
        return taskRepository.findByStatus(getTaskStatus(status))
                .stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TASK_NOT_FOUND.formatted(id)));
        return taskMapper.toTaskDto(task);
    }

    @Override
    @Transactional
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toTask(taskDto);
        task.setStatus(TaskStatus.TODO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toTaskDto(savedTask);
    }

    @Override
    @Transactional
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TASK_NOT_FOUND.formatted(id)));
        TaskStatus newStatus = taskDto.getStatus();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(newStatus);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toTaskDto(savedTask);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException(TASK_NOT_FOUND.formatted(id));
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDto> sort(String parameter) {
        if (parameter.equals(SORT_PARAMETER_DATE)) {
            return taskRepository.findAll().stream()
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .map(taskMapper::toTaskDto)
                    .toList();
        } else if (parameter.equals(SORT_PARAMETER_STATUS)) {
            return taskRepository.findAll().stream()
                    .sorted(Comparator.comparing(Task::getStatus))
                    .map(taskMapper::toTaskDto)
                    .toList();
        } else {
            throw new RuntimeException(WRONG_SORT_PARAMETER);
        }
    }
}
