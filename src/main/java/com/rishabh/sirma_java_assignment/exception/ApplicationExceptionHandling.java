package com.rishabh.sirma_java_assignment.exception;

import com.rishabh.sirma_java_assignment.service.exception.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rishabh.sirma_java_assignment.helper.keys;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApplicationExceptionHandling {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProjectNotFoundException.class)
    public Map<String, String> handleBusinessException(ProjectNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(keys.ERROR_MESSAGE, ex.getMessage());
        return errorMap;
    }
}
