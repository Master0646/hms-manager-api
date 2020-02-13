package com.wentao.hmsmanager.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wentao.hmsmanager.mapper.ClassMapper;
import com.wentao.hmsmanager.pojo.HmsClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService extends ServiceImpl<ClassMapper, HmsClass> {

    public List<HmsClass> selectByUserId(Integer userId) {
        return baseMapper.selectAllByUserId(userId);
    }
}
