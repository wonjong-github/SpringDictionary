package com.demo.manager.service;

import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;

public interface DictionaryService {
    String getValue(String key);

    String setValue(DictionaryManagementRequestDto dictionaryManagementRequestDto);

    DictionaryManagementResponseDto getValueForManager(String key);
}
