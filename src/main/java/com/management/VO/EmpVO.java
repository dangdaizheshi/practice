package com.management.VO;

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
public class EmpVO {
    private Integer id;
    private String name;
    private String username;
    private Integer gender;
    private String password;
    private String image;
    private Integer job;
    private Integer salary;
    private LocalDate entryDate;
    private Integer deptId;
    private String deptName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<EmpExpr> exprList;
}