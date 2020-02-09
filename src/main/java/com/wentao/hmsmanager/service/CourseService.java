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

    @Autowired
    ClassDao classDao;

    /**
     *  根据班级id查找课程列表
     * @param id 班级编号
     * @return 课程列表
     */
    public Set<HmsCourse> findAllByClassId(Integer id) {
        HmsClass hmsClass = new HmsClass();
        hmsClass.setId(id);
        Example<HmsClass> example = Example.of(hmsClass);
        Optional<HmsClass> one = classDao.findOne(example);
        if(one.isPresent()) {
            return one.get().getCourses();
        }
        return Collections.emptySet();
    }

}
