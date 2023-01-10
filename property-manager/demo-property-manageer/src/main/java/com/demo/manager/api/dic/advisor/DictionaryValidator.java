package com.demo.manager.api.dic.advisor;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DictionaryValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
