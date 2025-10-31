package ru.andr.javadaddy.advanced.javatodolist.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.andr.javadaddy.advanced.javatodolist.entity.Task;
import ru.andr.javadaddy.advanced.javatodolist.repository.TaskRepository;
import ru.andr.javadaddy.advanced.javatodolist.util.TaskStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTask_success() {
        String title = "Test Task";
        String description = "Description";
        LocalDate dueDate = LocalDate.now().plusDays(1);

        Task task = service.addTask(title, description, dueDate);

        assertEquals(title, task.getName());
        assertEquals(description, task.getDescription());
        assertEquals(dueDate, task.getDueDate());
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void testEditTask_success() {
        Long id = 1L;
        Task existingTask = new Task(id, "Old", "Old desc", LocalDate.now(), TaskStatus.TODO);

        when(repository.findById(id)).thenReturn(Optional.of(existingTask));

        Optional<Task> result = service.editTask(id, "New title", "New desc", LocalDate.now().plusDays(2), TaskStatus.IN_PROGRESS);

        assertTrue(result.isPresent());
        Task updated = result.get();
        assertEquals("New title", updated.getName());
        assertEquals("New desc", updated.getDescription());
        assertEquals(LocalDate.now().plusDays(2), updated.getDueDate());
        assertEquals(TaskStatus.IN_PROGRESS, updated.getStatus());

        verify(repository).save(existingTask);
    }

    @Test
    void testEditTask_taskNotFound() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        Optional<Task> result = service.editTask(id, "Title", "Desc", LocalDate.now(), TaskStatus.DONE);

        assertTrue(result.isEmpty());
        verify(repository, never()).save(any());
    }

    @Test
    void testDeleteTask_success() {
        Long id = 1L;
        when(repository.deleteById(id)).thenReturn(true);

        boolean deleted = service.deleteTask(id);

        assertTrue(deleted);
        verify(repository).deleteById(id);
    }

    @Test
    void testDeleteTask_deleteNotCompleted() {
        Long id = 1L;
        when(repository.deleteById(id)).thenReturn(false);

        boolean deleted = service.deleteTask(id);

        assertFalse(deleted);
        verify(repository).deleteById(id);
    }

    @Test
    void testFilterTasksByStatus_success() {
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now(), TaskStatus.TODO);
        Task task2 = new Task(2L, "T2", "Desc2", LocalDate.now(), TaskStatus.DONE);
        when(repository.findAll()).thenReturn(List.of(task1, task2));

        List<Task> filtered = service.filterTasksByStatus(TaskStatus.TODO);

        assertEquals(1, filtered.size());
        assertEquals(TaskStatus.TODO, filtered.get(0).getStatus());
    }

    @Test
    void testSortTasksByDueDate_success() {
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now().plusDays(2), TaskStatus.TODO);
        Task task2 = new Task(2L, "T2", "Desc2", LocalDate.now().plusDays(1), TaskStatus.DONE);
        when(repository.findAll()).thenReturn(List.of(task1, task2));

        List<Task> sorted = service.sortTasksByDueDate();

        assertEquals(task2, sorted.get(0));
        assertEquals(task1, sorted.get(1));
    }

    @Test
    void testSortTasksByStatus_success() {
        Task task1 = new Task(1L, "T1", "Desc1", LocalDate.now(), TaskStatus.IN_PROGRESS);
        Task task2 = new Task(2L, "T2", "Desc2", LocalDate.now(), TaskStatus.TODO);
        when(repository.findAll()).thenReturn(List.of(task1, task2));

        List<Task> sorted = service.sortTasksByStatus();

        assertEquals(task2, sorted.get(0));
        assertEquals(task1, sorted.get(1));
    }
}
