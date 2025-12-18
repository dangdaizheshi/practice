package com.management.service;

import com.management.DTO.AddEmpDTO;
import com.management.DTO.EmpDTO;
import com.management.VO.EmpVO;
import com.management.entity.PageResult;

import java.util.List;

public interface EmpService {
    PageResult getEmp(EmpDTO empDTO);

    void deleteEmpById(List<Integer> ids);

    void addEmp(AddEmpDTO addEmpDTO);

    EmpVO getEmpById(Integer id);

    void updateEmp(AddEmpDTO empDTO);
}
