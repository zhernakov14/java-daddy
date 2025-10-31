package ru.andr.javadaddy.advanced.javatodolist.controller;

import ru.andr.javadaddy.advanced.javatodolist.entity.Task;
import ru.andr.javadaddy.advanced.javatodolist.service.TaskService;
import ru.andr.javadaddy.advanced.javatodolist.util.TaskStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static ru.andr.javadaddy.advanced.javatodolist.util.InputUtil.parseDate;
import static ru.andr.javadaddy.advanced.javatodolist.util.InputUtil.parseId;
import static ru.andr.javadaddy.advanced.javatodolist.util.InputUtil.parseNonEmptyString;
import static ru.andr.javadaddy.advanced.javatodolist.util.InputUtil.parseStatus;

public class TaskController {

    private final TaskService taskService;
    private final Scanner scanner;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        printHelp();

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
        String newTaskName = parseNonEmptyString(scanner, "Введите название задачи: ");
        String newTaskDescription = parseNonEmptyString(scanner, "Введите описание задачи: ");
        LocalDate newTaskDate = parseDate(scanner);

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
        Optional<Long> idOpt = parseId(scanner, taskService);
        if (idOpt.isEmpty()) {
            return;
        }
        Long id = idOpt.get();

        String newTitle = parseNonEmptyString(scanner, "Введите название задачи: ");
        String newDescription = parseNonEmptyString(scanner, "Введите описание задачи: ");
        LocalDate newDueDate = parseDate(scanner);
        TaskStatus newStatus = parseStatus(scanner);

        Optional<Task> updatedTask = taskService.editTask(id, newTitle, newDescription, newDueDate, newStatus);
        System.out.println("Задача успешно обновлена: " + updatedTask.get());
    }

    private void handleDelete() {
        Optional<Long> idOpt = parseId(scanner, taskService);
        if (idOpt.isEmpty()) {
            return;
        }
        Long id = idOpt.get();

        if (taskService.deleteTask(id)) {
            System.out.println("Удаление прошло успешно");
        }
    }

    private void handleFilter() {
        TaskStatus status = parseStatus(scanner);
        List<Task> filteredTasks = taskService.filterTasksByStatus(status);

        if (filteredTasks.isEmpty()) {
            System.out.println("Задачи со статусом " + status + " не найдены.");
        } else {
            System.out.println("Задачи со статусом " + status + ":");
            filteredTasks.forEach(System.out::println);
        }
    }

    private void handleSort() {
        System.out.println("Выберите критерий сортировки:");
        System.out.println("1 - По дате выполнения");
        System.out.println("2 - По статусу");

        String choice = scanner.nextLine().trim();
        List<Task> sortedTasks;

        switch (choice) {
            case "1":
                sortedTasks = taskService.sortTasksByDueDate();
                System.out.println("Задачи, отсортированные по дате выполнения:");
                break;
            case "2":
                sortedTasks = taskService.sortTasksByStatus();
                System.out.println("Задачи, отсортированные по статусу:");
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
                return;
        }

        sortedTasks.forEach(System.out::println);
    }

    private void printHelp() {
        System.out.println("Доступные команды:");
        System.out.println(" add    - Добавить новую задачу");
        System.out.println(" list   - Показать все задачи");
        System.out.println(" edit   - Редактировать задачу");
        System.out.println(" delete - Удалить задачу");
        System.out.println(" filter - Показать задачи по статусу");
        System.out.println(" sort   - Отсортировать задачи");
        System.out.println(" exit   - Выйти из приложения");
        System.out.println();
    }
}
