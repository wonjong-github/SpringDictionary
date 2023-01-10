package com.demo.manager.api.error.dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ApiError{
    private final String errorArgument;
    private final List<String> errorMessages;
}