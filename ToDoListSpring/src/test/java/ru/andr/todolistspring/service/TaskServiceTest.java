package ru.andr.todolistspring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import ru.andr.todolistspring.entity.Task;
import ru.andr.todolistspring.model.TaskDto;
import ru.andr.todolistspring.repository.TaskRepository;
import ru.andr.todolistspring.util.enums.TaskStatus;
import ru.andr.todolistspring.util.mapper.TaskMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @InjectMocks
    private TaskServiceImpl service;

    @Mock
    private TaskRepository repository;

    @Spy
    private TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask_success() {
        String name = "Test Task";
        String description = "Description";
        LocalDate dueDate = LocalDate.now().plusDays(1);
        TaskDto inputDto = new TaskDto(null, name, description, dueDate, null);

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setName(inputDto.getName());
        savedTask.setDescription(inputDto.getDescription());
        savedTask.setDueDate(inputDto.getDueDate());
        savedTask.setStatus(TaskStatus.TODO);

        when(repository.save(any(Task.class))).thenReturn(savedTask);

        TaskDto actual = service.createTask(inputDto);

        assertEquals(name, actual.getName());
        assertEquals(description, actual.getDescription());
        assertEquals(dueDate, actual.getDueDate());
        assertEquals(TaskStatus.TODO.name(), actual.getStatus());
        verify(mapper).toTask(inputDto);
        verify(mapper).toTaskDto(savedTask);
    }

    @Test
    void testUpdateTask_success() {
        Long id = 1L;
        Task existingTask = new Task(id, "Old", "Old desc", LocalDate.now(), TaskStatus.TODO);
        String name = "New title";
        String description = "New desc";
        LocalDate dueDate = LocalDate.now().plusDays(2);
        TaskDto inputDto = new TaskDto(id, name, description, dueDate, "in_progress");

        Task savedTask = new Task();
        savedTask.setId(id);
        savedTask.setName(inputDto.getName());
        savedTask.setDescription(inputDto.getDescription());
        savedTask.setDueDate(inputDto.getDueDate());
        savedTask.setStatus(TaskStatus.IN_PROGRESS);

        when(repository.findById(id)).thenReturn(Optional.of(existingTask));
        when(repository.save(any(Task.class))).thenReturn(savedTask);

        TaskDto actual = service.updateTask(id, inputDto);

        assertEquals("New title", actual.getName());
        assertEquals("New desc", actual.getDescription());
        assertEquals(LocalDate.now().plusDays(2), actual.getDueDate());
        assertEquals(TaskStatus.IN_PROGRESS.name(), actual.getStatus());

        verify(repository).save(existingTask);
    }

    @Test
    void testUpdateTask_taskNotFound() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        String name = "New title";
        String description = "New desc";
        LocalDate dueDate = LocalDate.now().plusDays(2);
        TaskDto inputDto = new TaskDto(1L, name, description, dueDate, "in_progress");

        assertThrows(RuntimeException.class, () -> service.updateTask(id, inputDto));
        verify(repository, never()).save(any());
    }

    @Test
    void testDeleteTask_success() {
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(true);

        service.deleteTask(id);

        verify(repository).deleteById(id);
    }

    @Test
    void testDeleteTask_deleteNotCompleted() {
        Long id = 1L;

        assertThrows(RuntimeException.class, () -> service.deleteTask(id));
        verify(repository, never()).deleteById(id);
    }

    @Test
    void testGetTasksByStatus_success() {
        String status = "done";
        TaskStatus taskStatus = TaskStatus.getTaskStatus(status);
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now(), TaskStatus.DONE);
        when(repository.findByStatus(taskStatus)).thenReturn(List.of(task1));

        List<TaskDto> filtered = service.getTasksByStatus(status);

        assertEquals(1, filtered.size());
        assertEquals(TaskStatus.DONE.name(), filtered.get(0).getStatus());
    }

    @Test
    void testSortByDueDate_success() {
        String parameter = "date";
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now().plusDays(2), TaskStatus.DONE);
        Task task2 = new Task(2L, "T2", "Desc2", LocalDate.now().plusDays(1), TaskStatus.DONE);
        TaskDto taskDto1 = new TaskDto(1L, "T1", "Desc1", LocalDate.now().plusDays(2), "DONE");
        TaskDto taskDto2 = new TaskDto(2L, "T2", "Desc2", LocalDate.now().plusDays(1), "DONE");
        when(repository.findAll()).thenReturn(List.of(task1, task2));

        List<TaskDto> sorted = service.sort(parameter);

        assertEquals(taskDto2, sorted.get(0));
        assertEquals(taskDto1, sorted.get(1));
    }

    @Test
    void testSortByStatus_success() {
        String parameter = "status";
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now().plusDays(2), TaskStatus.IN_PROGRESS);
        Task task2 = new Task(2L, "T2", "Desc2", LocalDate.now().plusDays(1), TaskStatus.TODO);
        TaskDto taskDto1 = new TaskDto(1L, "T1", "Desc1", LocalDate.now().plusDays(2), "IN_PROGRESS");
        TaskDto taskDto2 = new TaskDto(2L, "T2", "Desc2", LocalDate.now().plusDays(1), "TODO");
        when(repository.findAll()).thenReturn(List.of(task1, task2));

        List<TaskDto> sorted = service.sort(parameter);

        assertEquals(taskDto2, sorted.get(0));
        assertEquals(taskDto1, sorted.get(1));
    }

    @Test
    void testSortByStatus_wrongParameter() {
        String parameter = "wrong";

        assertThrows(RuntimeException.class, () -> service.sort(parameter));
        verify(repository, never()).findAll();
    }
}
