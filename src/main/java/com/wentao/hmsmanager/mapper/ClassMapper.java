package com.wentao.hmsmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wentao.hmsmanager.pojo.HmsClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<HmsClass> {

    @Select(value = "select * from hms_class hc, hms_user_class huc where hc.id = huc.class_id and huc.user_id = #{userId}")
    List<HmsClass> selectAllByUserId(Integer userId);
}