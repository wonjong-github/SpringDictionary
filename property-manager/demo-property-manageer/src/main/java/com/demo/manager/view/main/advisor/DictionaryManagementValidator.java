package com.demo.manager.view.main.advisor;

import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DictionaryManagementValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(DictionaryManagementRequestDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //TODO validate 추가하기

    }
}
