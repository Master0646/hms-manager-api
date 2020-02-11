package com.wentao.hmsmanager.service;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.repository.ClassDao;
import com.wentao.hmsmanager.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public HmsCourse findById(Integer courseId) {
        HmsCourse course = new HmsCourse();
        course.setId(courseId);
        Example<HmsCourse> example = Example.of(course);
        Optional<HmsCourse> optionalHmsCourse = courseDao.findOne(example);
        return optionalHmsCourse.orElse(null);
    }

}
