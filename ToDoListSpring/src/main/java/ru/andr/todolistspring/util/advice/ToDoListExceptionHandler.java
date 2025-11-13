package ru.andr.todolistspring.util.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.andr.todolistspring.model.ExceptionResponse;
import ru.andr.todolistspring.util.exception.TaskStatusException;

@RestControllerAdvice
public class ToDoListExceptionHandler {

    private final String STATUS_NOT_FOUND = "Введенный статус должен быть одним из предложенных (TODO, IN_PROGRESS, DONE)";

    @ExceptionHandler(TaskStatusException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions() {
        ExceptionResponse response = new ExceptionResponse(STATUS_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}