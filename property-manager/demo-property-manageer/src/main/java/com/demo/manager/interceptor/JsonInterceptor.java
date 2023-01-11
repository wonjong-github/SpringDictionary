package com.demo.manager.interceptor;

import com.demo.manager.view.main.dto.RenderJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RequiredArgsConstructor
@Component
@Slf4j
public class JsonInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(Objects.isNull(modelAndView) || Objects.isNull(modelAndView.getModel()) || Objects.isNull(modelAndView.getModel().get("renderJson"))){
            return;
        }
        RenderJson renderJson = (RenderJson) modelAndView.getModel().get("renderJson");
        try{
            String json = objectMapper.writeValueAsString(renderJson);
            modelAndView.getModel().put("renderJson", json);
        }catch (Exception e){
            log.error("renderJson -> json converting error {}", e.getMessage());
        }

    }
}
