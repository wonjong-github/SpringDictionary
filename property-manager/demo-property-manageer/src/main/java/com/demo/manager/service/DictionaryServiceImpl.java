package com.demo.manager.service;

import com.demo.manager.domain.DicitionaryRepository;
import com.demo.manager.domain.Dictionary;
import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


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
}
