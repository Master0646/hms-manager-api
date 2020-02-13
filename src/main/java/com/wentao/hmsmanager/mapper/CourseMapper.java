package com.wentao.hmsmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wentao.hmsmanager.pojo.HmsCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<HmsCourse> {

    List<HmsCourse> selectAllByClassId(Integer classId);

    HmsCourse selectByClassIdAndCourseId(@Param("classId") Integer classId, @Param("courseId") Integer courseId);

}