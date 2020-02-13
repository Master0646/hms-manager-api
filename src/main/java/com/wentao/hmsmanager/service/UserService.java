package com.wentao.hmsmanager.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wentao.hmsmanager.config.security.HmsUserDetails;
import com.wentao.hmsmanager.mapper.UserMapper;
import com.wentao.hmsmanager.pojo.HmsUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, HmsUser> implements UserDetailsService {

    public HmsUser findById(Integer userId) {
        return baseMapper.selectById(userId);
    }

    public HmsUser selectOneByUsername(String username) {
        return baseMapper.selectByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        HmsUser hmsUser = baseMapper.selectByUsername(s);
        return new HmsUserDetails(hmsUser);
    }

}
