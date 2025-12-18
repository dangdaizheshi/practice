package com.management.controller;

import com.management.DTO.AddEmpDTO;
import com.management.DTO.EmpDTO;
import com.management.VO.EmpVO;
import com.management.entity.PageResult;
import com.management.entity.Result;
import com.management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping()
    public Result<PageResult> getEmp(EmpDTO empDTO){
        PageResult pageResult = empService.getEmp(empDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping()
    public Result deleteEmpById(@RequestParam List<Integer> ids){
        empService.deleteEmpById(ids);
        return Result.success();
    }

    @PostMapping()
    public Result addEmp(@RequestBody AddEmpDTO addEmpDTO){
        empService.addEmp(addEmpDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<EmpVO> getEmpById(@PathVariable Integer id){
        EmpVO empVO = empService.getEmpById(id);
        return Result.success(empVO);
    }

    @PutMapping("")
    public Result updateEmp(@RequestBody AddEmpDTO empDTO){
        empService.updateEmp(empDTO);
        return Result.success();
    }
}
