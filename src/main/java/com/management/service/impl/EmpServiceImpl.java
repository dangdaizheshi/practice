package com.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.management.DTO.AddEmpDTO;
import com.management.DTO.EmpDTO;
import com.management.VO.EmpVO;
import com.management.entity.Emp;
import com.management.entity.EmpExpr;
import com.management.entity.PageResult;
import com.management.mapper.EmpExprMapper;
import com.management.mapper.EmpMapper;
import com.management.service.EmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Override
    public PageResult getEmp(EmpDTO empDTO) {
        PageHelper.startPage(empDTO.getPage(), empDTO.getPageSize());
        Page<EmpVO> page = empMapper.getEmp(empDTO);
        return new PageResult(page.getPages(), page.getResult());
    }

    @Override
    public void deleteEmpById(List<Integer> ids) {
        empMapper.deleteEmpById(ids);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void addEmp(AddEmpDTO addEmpDTO) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(addEmpDTO, emp);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
        List<EmpExpr> exprList = addEmpDTO.getExprList();
        for (EmpExpr empExpr : exprList) {
            empExpr.setEmpId(emp.getId());
        }
        empExprMapper.addEmpExpr(exprList);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public EmpVO getEmpById(Integer id) {
        EmpVO empVO = empMapper.getEmpById(id);
        List<EmpExpr> exprList = empExprMapper.getEmpExprById(id);
        empVO.setExprList(exprList);
        return empVO;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateEmp(AddEmpDTO empDTO) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(empDTO, emp);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
        empExprMapper.deleteEmpExprById(emp.getId());
        List<EmpExpr> exprList = empDTO.getExprList();
        empExprMapper.addEmpExpr(exprList);
    }
}
