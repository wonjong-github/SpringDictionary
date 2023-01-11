package com.demo.manager.view.main;


import com.demo.manager.service.DictionaryService;
import com.demo.manager.view.main.advisor.DictionaryManagementValidator;
import com.demo.manager.view.main.dto.DictionaryManagementRequestDto;
import com.demo.manager.view.main.dto.DictionaryManagementResponseDto;
import com.demo.manager.view.main.dto.RenderJson;
import io.netty.util.internal.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/management")
@RequiredArgsConstructor
public class DictionaryManagementController {

    private final DictionaryService dictionaryService;

    private final DictionaryManagementValidator dictionaryManagementValidator;


    @GetMapping(path = "/view")
    public String managementView(Model model,@RequestParam(defaultValue = "N") String registerYn, @RequestParam(defaultValue = "1", required = false) Integer page){
        RenderJson renderJson = new RenderJson();
        if("Y".equals(registerYn)){
            renderJson.put("dictionaries", Collections.EMPTY_LIST);
            model.addAttribute("dictionaries", Collections.EMPTY_LIST);
        }else{
            Pageable pageable = PageRequest.of(page - 1, 10);
            List<DictionaryManagementResponseDto> dictionaries = dictionaryService.getDictionaryByPage(pageable);
            model.addAttribute("dictionaries", dictionaries);
            renderJson.put("dictionaries", dictionaries);
        }


        model.addAttribute("renderJson", renderJson);
        return "index";
    }

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
