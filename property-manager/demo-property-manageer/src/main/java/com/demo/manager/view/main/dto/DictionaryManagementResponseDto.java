package com.demo.manager.view.main.dto;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictionaryManagementResponseDto {

    private String key;

    private String value;

    private String code;

    private String message;

    public static DictionaryManagementResponseDto of(String key, String value){
        return DictionaryManagementResponseDto.builder()
                .key(key)
                .value(value)
                .code("0000")
                .build();
    }

    public static DictionaryManagementResponseDto empty(){
        return DictionaryManagementResponseDto.builder()
                .message("해당되는 값이 없습니다.")
                .code("0001")
                .build();
    }
    
}
