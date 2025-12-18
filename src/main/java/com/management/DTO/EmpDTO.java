package com.management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;
    private Integer page;
    private Integer pageSize;
}
