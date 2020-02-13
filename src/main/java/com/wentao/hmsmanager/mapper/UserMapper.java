package com.wentao.hmsmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wentao.hmsmanager.pojo.HmsUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<HmsUser> {

    HmsUser selectByUsername(String username);

}