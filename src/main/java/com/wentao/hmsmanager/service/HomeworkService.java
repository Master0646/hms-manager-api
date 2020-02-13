package com.wentao.hmsmanager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wentao.hmsmanager.mapper.HomeworkMapper;
import com.wentao.hmsmanager.pojo.HmsHomework;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeworkService extends ServiceImpl<HomeworkMapper, HmsHomework> {

    @Transactional(rollbackFor = Exception.class)
    public Integer insertWithCourseId(Integer courseId, HmsHomework homework) {
        baseMapper.insert(homework);
        HmsHomework select = baseMapper.selectOne(new QueryWrapper<>(homework));
        return baseMapper.insertWithCourseId(courseId, select.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insertWithClassId(Integer classId, Integer homeworkId) {
        return baseMapper.insertWithClassId(classId, homeworkId);
    }

    public Page<HmsHomework> selectAllByCourseIdAndClassId(Integer classId, Integer courseId, Integer current, Integer size) {
        Page<HmsHomework> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return baseMapper.selectAllByCourseIdAndClassId(page, classId, courseId);
    }

}
