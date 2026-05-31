package com.matiss.entertainment_storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> MediaItemEmptyFieldException(MethodArgumentNotValidException notValidException) {
        return new ResponseEntity<String>(notValidException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MediaItemNotFoundException.class)
    public ResponseEntity<String> MediaItemNotFoundException(MediaItemNotFoundException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(illegalArgumentException.getMessage());
    }

}
