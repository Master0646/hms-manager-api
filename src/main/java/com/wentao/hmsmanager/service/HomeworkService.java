package com.wentao.hmsmanager.service;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.entity.HmsHomework;
import com.wentao.hmsmanager.repository.HomeworkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class HomeworkService {

    @Autowired
    HomeworkDao homeworkDao;

    @Transactional(rollbackFor = Exception.class)
    public HmsHomework save(HmsCourse course, HmsHomework homework) {
        homework.setCourses(course);
        return homeworkDao.save(homework);
    }

    public HmsHomework getById(Integer homeworkId) {
        HmsHomework homework = new HmsHomework();
        homework.setId(homeworkId);
        Optional<HmsHomework> optionalHomework = homeworkDao.findOne(Example.of(homework));
        return optionalHomework.orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public HmsHomework save(HmsClass hmsClass, Integer homeworkId) {
        HmsHomework homework = new HmsHomework();
        homework.setId(homeworkId);
        HmsHomework foundHomework = getById(homeworkId);
        if (foundHomework != null) {
            foundHomework.setClasses(hmsClass);
            return homeworkDao.save(foundHomework);
        }
        return null;
    }

    public Page<HmsHomework> findAllByCourseAndClass(HmsClass hmsClass, HmsCourse course, Integer page, Integer size) {
        HmsHomework homework = new HmsHomework();
        homework.setCourses(course);
        homework.setClasses(hmsClass);
        Example<HmsHomework> example = Example.of(homework);
        return homeworkDao.findAll(example, PageRequest.of(page, size));
    }

}
