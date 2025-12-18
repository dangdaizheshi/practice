package com.management.controller;

import com.management.entity.Clazz;
import com.management.entity.Result;
import com.management.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        clazzService.addClazz(clazz);
        return Result.success();
    }
}
