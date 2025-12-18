package com.management.service.impl;

import com.management.DTO.AddDeptDTO;
import com.management.entity.Dept;
import com.management.mapper.DeptMapper;
import com.management.service.DeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void addDept(AddDeptDTO deptDTO) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptDTO, dept);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
