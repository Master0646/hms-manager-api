package com.wentao.hmsmanager.service;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsUser;
import com.wentao.hmsmanager.repository.ClassDao;
import com.wentao.hmsmanager.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;

    public HmsClass findById(Integer classId) {
        HmsClass hmsClass = new HmsClass();
        hmsClass.setId(classId);
        Example<HmsClass> example = Example.of(hmsClass);
        Optional<HmsClass> optionalHmsClass = classDao.findOne(example);
        return optionalHmsClass.orElse(null);
    }

}
