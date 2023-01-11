package com.demo.manager.service;

import com.demo.manager.domain.DicitionaryRepository;
import com.demo.manager.domain.Dictionary;
import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DicitionaryRepository dicitionaryRepository;

    @Transactional(readOnly = true)
    @Override
    public String getValue(String key) {
        return dicitionaryRepository.find(key);
    }

    @Transactional(readOnly = true)
    @Override
    public DictionaryManagementResponseDto getValueForManager(String key) {
        Dictionary foundDictionary = dicitionaryRepository.findForManager(key);
        if(Objects.isNull(foundDictionary)){
            return DictionaryManagementResponseDto.empty();
        }
        return DictionaryManagementResponseDto.of(foundDictionary.getKey(), foundDictionary.getValue());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public String setValue(DictionaryManagementRequestDto dictionaryManagementRequestDto) {

        Dictionary checkDictionary = dicitionaryRepository.findForManager(dictionaryManagementRequestDto.getKey());
        if(!Objects.isNull(checkDictionary)){
            checkDictionary.updateValue(dictionaryManagementRequestDto.getValue());
            return "UPDATED";
        }

        Dictionary dictionary = new Dictionary(dictionaryManagementRequestDto.getKey(), dictionaryManagementRequestDto.getValue());
        dicitionaryRepository.save(dictionary);
        return "SAVED";
    }

    @Transactional(readOnly = true)
    @Override
    public List<DictionaryManagementResponseDto> getDictionaryByPage(Pageable pageable) {
        Page<Dictionary> dictionaries = dicitionaryRepository.findAll(pageable);

        return dictionaries.stream()
                .map(DictionaryManagementResponseDto::convert)
                .collect(Collectors.toList());
    }
}
