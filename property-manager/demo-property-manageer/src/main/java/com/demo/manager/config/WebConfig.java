package com.demo.manager.config;


import com.demo.manager.interceptor.JsonInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.*;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final JsonInterceptor jsonInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.PATCH.name(),
                        HttpMethod.OPTIONS.name(),
                        HttpMethod.DELETE.name());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration reg2 = registry.addResourceHandler("css/**");
        reg2.addResourceLocations("classpath:/css/");
        reg2.setCacheControl(CacheControl.maxAge(Duration.ofMinutes(60)));

        ResourceHandlerRegistration reg3 = registry.addResourceHandler("js/**");
        reg3.addResourceLocations("classpath:/js/");
        reg3.setCacheControl(CacheControl.noCache());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(jsonInterceptor)
                .addPathPatterns("/management/view/**");
    }
}
