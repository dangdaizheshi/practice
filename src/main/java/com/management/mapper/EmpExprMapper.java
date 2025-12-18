package com.management.mapper;

import com.management.entity.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void addEmpExpr(List<EmpExpr> exprList);

    @Select("select * from emp_expr where emp_id = #{id}")
    List<EmpExpr> getEmpExprById(Integer id);

    @Delete("delete from emp_expr where emp_id = #{id}")
    void deleteEmpExprById(Integer id);
}
