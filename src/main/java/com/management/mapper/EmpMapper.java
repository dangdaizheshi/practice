package com.management.mapper;

import com.github.pagehelper.Page;
import com.management.DTO.EmpDTO;
import com.management.VO.EmpVO;
import com.management.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    Page<EmpVO> getEmp(EmpDTO empDTO);

    void deleteEmpById(List<Integer> ids);

    void addEmp(Emp emp);

    EmpVO getEmpById(Integer id);

    void updateEmp(Emp emp);
}
