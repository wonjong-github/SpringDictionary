package com.demo.manager.view.main;


import com.demo.manager.service.DictionaryService;
import com.demo.manager.view.main.advisor.DictionaryManagementValidator;
import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;
import io.netty.util.internal.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/management")
@RequiredArgsConstructor
public class DictionaryManagementController {

    private final DictionaryService dictionaryService;

    private final DictionaryManagementValidator dictionaryManagementValidator;

    @PostMapping(path = "/dic")
    public ResponseEntity<String> saveDictionaryData(@Valid @RequestBody DictionaryManagementRequestDto dictionaryManagementRequestDto){

        String status = dictionaryService.setValue(dictionaryManagementRequestDto);
        return ResponseEntity.ok(status);
    }

    @GetMapping(path = "/dic")
    public ResponseEntity<DictionaryManagementResponseDto> retrieveDictionaryData(@RequestParam("key") String key){
                return ResponseEntity.ok(dictionaryService.getValueForManager(key));
    }

    @InitBinder(value = {"dictionaryManagementRequestDto"})
    private void initBinder(WebDataBinder binder){
        binder.addValidators(dictionaryManagementValidator);
    }

}
