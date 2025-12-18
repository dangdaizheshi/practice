package com.management.service.impl;

import com.management.entity.Clazz;
import com.management.mapper.ClazzMapper;
import com.management.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.insert(clazz);
    }
}
