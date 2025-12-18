package com.management.service;

import com.management.DTO.AddDeptDTO;
import com.management.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getDept();

    void deleteDeptById(Integer id);

    void addDept(AddDeptDTO deptDTO);

    Dept getDeptById(Integer id);

    void updateDept(Dept dept);
}