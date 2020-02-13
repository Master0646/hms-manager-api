package com.wentao.hmsmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wentao.hmsmanager.pojo.HmsHomework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeworkMapper extends BaseMapper<HmsHomework> {

    @Insert(value = "insert into hms_course_homework(course_id, homework_id) value(#{courseId}, #{homeworkId})")
    Integer insertWithCourseId(Integer courseId, Integer homeworkId);

    @Insert(value = "insert into hms_class_homework(class_id, homeworkId) value(#{classId}, #{homeworkId})")
    Integer insertWithClassId(Integer classId, Integer homeworkId);

    @Select(value = "SELECT * FROM hms_homework ch " +
            "LEFT JOIN hms_course_homework csh ON ch.id = csh.homework_id " +
            "LEFT JOIN hms_class_homework clh ON ch.id = clh.homework_id " +
            "WHERE csh.course_id = #{courseId} AND clh.class_id = #{classId}")
    Page<HmsHomework> selectAllByCourseIdAndClassId(Page<HmsHomework> page,
                                                    @Param("classId") Integer classId,
                                                    @Param("courseId") Integer courseId);

}