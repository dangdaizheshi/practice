package com.management.DTO;

import com.management.entity.EmpExpr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddEmpDTO {
    private Integer id;
    private String name;
    private String username;
    private Integer gender;
    private String image;
    private String phone;
    private Integer job;
    private Integer salary;
    private LocalDate entryDate;
    private Integer deptId;
    private List<EmpExpr> exprList;
}
