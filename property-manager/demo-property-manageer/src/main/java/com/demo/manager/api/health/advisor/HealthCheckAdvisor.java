package com.demo.manager.api.health.advisor;


import com.demo.manager.api.error.dto.ApiError;
import com.demo.manager.api.health.controller.HealthCheckController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice(basePackageClasses = {HealthCheckController.class})
public class HealthCheckAdvisor{

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ApiError>> healthCheckBindingErrorProcessor(BindingResult bindingResult){
       return ResponseEntity.badRequest().body(converter(bindingResult));
    }

    private static List<ApiError> converter(BindingResult bindingResult){
       return bindingResult.getFieldErrors()
                .stream()
                .map(fieldError -> new ApiError(fieldError.getField(), Collections.singletonList(fieldError.getDefaultMessage())))
                .collect(Collectors.toList());
    }
}
