package ru.andr.javadaddy.advanced.javatodolist;

import ru.andr.javadaddy.advanced.javatodolist.controller.TaskController;
import ru.andr.javadaddy.advanced.javatodolist.repository.TaskRepository;
import ru.andr.javadaddy.advanced.javatodolist.service.TaskService;

public class JavaToDoList {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);
        TaskController controller = new TaskController(service);

        controller.run();
    }
}
