package com.demo.manager.api.health.dto;

import java.util.List;

public class HealthCheckResponseDto {
    private String health;
    private List<String> activeProfiles;

    HealthCheckResponseDto(String health, List<String> activeProfiles) {
        this.health = health;
        this.activeProfiles = activeProfiles;
    }

    public static HealthCheckResponseDtoBuilder builder() {
        return new HealthCheckResponseDtoBuilder();
    }

    public String getHealth() {
        return this.health;
    }

    public List<String> getActiveProfiles() {
        return this.activeProfiles;
    }

    public static class HealthCheckResponseDtoBuilder {
        private String health;
        private List<String> activeProfiles;

        HealthCheckResponseDtoBuilder() {
        }

        public HealthCheckResponseDtoBuilder health(String health) {
            this.health = health;
            return this;
        }

        public HealthCheckResponseDtoBuilder activeProfiles(List<String> activeProfiles) {
            this.activeProfiles = activeProfiles;
            return this;
        }

        public HealthCheckResponseDto build() {
            return new HealthCheckResponseDto(this.health, this.activeProfiles);
        }

        public String toString() {
            return "HealthCheckResponseDto.HealthCheckResponseDtoBuilder(health=" + this.health + ", activeProfiles=" + this.activeProfiles + ")";
        }
    }
}
