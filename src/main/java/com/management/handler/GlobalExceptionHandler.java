package com.management.handler;

import com.management.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("emp.username")) {
            return Result.error("用户名已存在，请使用其他用户名");
        }
        return Result.error("数据操作异常：" + e.getMessage());
    }
}
