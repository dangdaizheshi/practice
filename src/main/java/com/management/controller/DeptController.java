package com.management.controller;

import com.management.DTO.AddDeptDTO;
import com.management.entity.Dept;
import com.management.entity.Result;
import com.management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping()
    public Result<List<Dept>> getDept(){
        List<Dept> list = deptService.getDept();
        return Result.success(list);
    }

    @DeleteMapping()
    public Result deleteDeptById(Integer id){
        deptService.deleteDeptById(id);
        return Result.success();
    }

    @PostMapping()
    public Result addDept(@RequestBody AddDeptDTO deptDTO){
        deptService.addDept(deptDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Dept> getDeptById(@PathVariable Integer id){
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }

    @PutMapping()
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }
}
