package com.demo.manager.view.main.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryManagementRequestDto {

    @NotBlank(message = "key 값은 필수입니다.")
    private String key;
    @NotBlank(message = "value 값은 필수입니다.")
    private String value;

    private String modifier;

}
