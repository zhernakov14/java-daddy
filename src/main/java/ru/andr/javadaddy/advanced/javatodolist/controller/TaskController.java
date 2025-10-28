package ru.andr.javadaddy.advanced.javatodolist.controller;

import ru.andr.javadaddy.advanced.javatodolist.entity.Task;
import ru.andr.javadaddy.advanced.javatodolist.service.TaskService;
import ru.andr.javadaddy.advanced.javatodolist.util.TaskStatus;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class TaskController {

    private final TaskService taskService;
    private final Scanner scanner;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "add":
                    handleAdd();
                    break;
                case "list":
                    handleList();
                    break;
                case "edit":
                    handleEdit();
                    break;
                case "delete":
                    handleDelete();
                    break;
                case "filter":
                    handleFilter();
                    break;
                case "sort":
                    handleSort();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private void handleAdd() {
        System.out.print("Введите название задачи: ");
        String newTaskName = scanner.nextLine().trim();

        System.out.print("Введите описание задачи: ");
        String newTaskDescription = scanner.nextLine().trim();

        LocalDate newTaskDate = null;
        while (newTaskDate == null) {
            System.out.print("Введите дату выполнения задачи в формате ГГГГ-ММ-ДД: ");
            String input = scanner.nextLine().trim();
            try {
                newTaskDate = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты, попробуйте еще раз.");
            }
        }

        Task task = taskService.addTask(newTaskName, newTaskDescription, newTaskDate);
        System.out.println("Создана задача: " + task.toString());
    }

    private void handleList() {
        List<Task> tasks = taskService.getAllTasks();
        if (!tasks.isEmpty()) {
            System.out.println("Список всех задач:");
            tasks.forEach(System.out::println);
        } else {
            System.out.println("Список задач пуст.");
        }
    }

    private void handleEdit() {
        System.out.print("Введите ID задачи для редактирования: ");
        String idInputForEdit = scanner.nextLine().trim();
        UUID id;
        try {
            id = UUID.fromString(idInputForEdit);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный формат ID.");
            return;
        }

        if (taskService.getTask(id).isEmpty()) {
            System.out.println("Задача с таким ID не найдена.");
            return;
        }

        System.out.print("Новое название: ");
        String newTitle = scanner.nextLine().trim();

        System.out.print("Новое описание: ");
        String newDescription = scanner.nextLine().trim();

        LocalDate newDueDate = null;
        while (newDueDate == null) {
            System.out.print("Новая дата (ГГГГ-ММ-ДД): ");
            String dateInput = scanner.nextLine().trim();
            try {
                newDueDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты, попробуйте снова.");
            }
        }

        TaskStatus newStatus = null;
        while (newStatus == null) {
            System.out.print("Новый статус (TODO, IN_PROGRESS, DONE): ");
            String statusInput = scanner.nextLine().trim().toUpperCase();
            try {
                newStatus = TaskStatus.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный статус, попробуйте снова.");
            }
        }

        Optional<Task> updatedTask = taskService.editTask(id, newTitle, newDescription, newDueDate, newStatus);
        System.out.println("Задача успешно обновлена: " + updatedTask.get());
    }

    private void handleDelete() {
        System.out.print("Введите ID задачи для удаления: ");
        String idInputForDelete = scanner.nextLine().trim();
        UUID id;
        try {
            id = UUID.fromString(idInputForDelete);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный формат ID.");
            return;
        }

        if (taskService.getTask(id).isEmpty()) {
            System.out.println("Задача с таким ID не найдена.");
            return;
        }

        if (taskService.deleteTask(id)) {
            System.out.println("Удаление прошло успешно");
        }
    }

    private void handleFilter() {
        // Логика фильтрации задач по статусу
    }

    private void handleSort() {
        // Логика сортировки задач
    }
}
