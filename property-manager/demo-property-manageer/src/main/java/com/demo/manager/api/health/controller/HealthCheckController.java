package com.demo.manager.api.health.controller;

import com.demo.manager.api.health.dto.HealthCheckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    private final Environment environment;

    @GetMapping({"/health"})
    public ResponseEntity<HealthCheckResponseDto> healthCheck() {
        HealthCheckResponseDto healthCheckResponseDto = HealthCheckResponseDto.builder().health("ok").activeProfiles(Arrays.asList(this.environment.getActiveProfiles())).build();
        return ResponseEntity.ok(healthCheckResponseDto);
    }
}
