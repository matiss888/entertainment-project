package com.matiss.entertainment_storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> mediaItemEmptyFieldException(MethodArgumentNotValidException notValidException) {
        return new ResponseEntity<String>(notValidException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MediaItemNotFoundException.class)
    public ResponseEntity<String> mediaItemNotFoundException(MediaItemNotFoundException notFoundException) {
        return new ResponseEntity<String>(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        return new ResponseEntity<String>(illegalArgumentException.getMessage(), HttpStatus.CONFLICT);

    }

}
