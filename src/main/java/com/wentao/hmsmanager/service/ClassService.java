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
    @Autowired
    private UserDao userDao;

    /**
     * 查找对应用户所在的班级
     * @param id 用户id
     * @return 用户所在班级列表
     */
    public List<HmsClass> findAllByUserId(Integer id) {
        HmsUser user = new HmsUser();
        user.setId(id);
        Example<HmsUser> example = Example.of(user);
        Optional<HmsUser> one = userDao.findOne(example);
        if(one.isPresent()) {
            return one.get().getHmsClass();
        }
        return Collections.emptyList();
    }

}
