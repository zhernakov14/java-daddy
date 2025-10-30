package ru.andr.javadaddy.advanced.javatodolist.util;

import ru.andr.javadaddy.advanced.javatodolist.service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class InputUtil {

    public static LocalDate parseDate(Scanner scanner) {
        LocalDate date = null;
        while (date == null) {
            System.out.print("Введите дату (ГГГГ-ММ-ДД): ");
            String input = scanner.nextLine().trim();
            try {
                date = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты, попробуйте снова.");
            }
        }
        return date;
    }

    public static Optional<UUID> parseId(Scanner scanner, TaskService taskService) {
        System.out.print("Введите ID задачи: ");
        String idInput = scanner.nextLine().trim();
        UUID id;
        try {
            id = UUID.fromString(idInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный формат ID.");
            return Optional.empty();
        }

        if (taskService.getTask(id).isEmpty()) {
            System.out.println("Задача с таким ID не найдена.");
            return Optional.empty();
        }
        return Optional.of(id);
    }

    public static TaskStatus parseStatus(Scanner scanner) {

        TaskStatus status = null;
        while (status == null) {
            System.out.print("Введите статус (TODO, IN_PROGRESS, DONE): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                status = TaskStatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Такой статус не существует, попробуйте снова.");
            }
        }
        return status;
    }
}
