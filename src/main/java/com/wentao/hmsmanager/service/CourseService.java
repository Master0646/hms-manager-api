package com.wentao.hmsmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wentao.hmsmanager.mapper.CourseMapper;
import com.wentao.hmsmanager.pojo.HmsCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends ServiceImpl<CourseMapper, HmsCourse> {

    public HmsCourse selectByClassIdAndCourseId(Integer classId, Integer courseId) {
        return baseMapper.selectByClassIdAndCourseId(classId, courseId);
    }

    public List<HmsCourse> getAllByClassId(Integer classId) {
        return baseMapper.selectAllByClassId(classId);
    }

}
