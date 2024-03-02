package com.exceptionhandlingprojct.advice;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(CustomException.NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(CustomException.NotFoundException ex) {
        String s = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(s);
    }
    @ExceptionHandler(CustomException.BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequestException(CustomException.BadRequestException e) {
       return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<String> processUnmergeException(final MethodArgumentNotValidException ex) {
        String s = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.ok().body(s);
    }

}



