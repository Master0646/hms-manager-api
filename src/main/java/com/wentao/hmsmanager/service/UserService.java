package com.wentao.hmsmanager.service;

import com.wentao.hmsmanager.config.security.HmsUserDetails;
import com.wentao.hmsmanager.entity.HmsUser;
import com.wentao.hmsmanager.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        HmsUser hmsUser = new HmsUser();
        hmsUser.setUsername(s);
        Example<HmsUser> example = Example.of(hmsUser);
        Optional<HmsUser> one = userDao.findOne(example);
        // 如果用户存在，将查询到的用户封装到UserDetails中并返回，佛则返回null
        return one.map(HmsUserDetails::new).orElse(null);
    }
}
