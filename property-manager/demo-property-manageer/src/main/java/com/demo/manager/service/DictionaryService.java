package com.demo.manager.service;

import com.demo.manager.domain.Dictionary;
import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DictionaryService {
    String getValue(String key);

    String setValue(DictionaryManagementRequestDto dictionaryManagementRequestDto);

    DictionaryManagementResponseDto getValueForManager(String key);

    List<DictionaryManagementResponseDto> getDictionaryByPage(Pageable pageable);
}
