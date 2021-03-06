package com.wentao.hmsmanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wentao.hmsmanager.entity.vo.CourseDetailVo;
import com.wentao.hmsmanager.pojo.HmsCourse;
import com.wentao.hmsmanager.pojo.HmsHomework;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.service.CourseService;
import com.wentao.hmsmanager.service.HomeworkService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private ClassService classService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/api/v1/course/{classId}")
    public ApiResponse info(@PathVariable Integer classId) {
        List<HmsCourse> courses = courseService.getAllByClassId(classId);
        return ApiResponse.ok(courses);
    }

    @GetMapping("/api/v1/course/detail/{classId}/{courseId}/{page}")
    public ApiResponse detail(@PathVariable Integer classId,
                              @PathVariable Integer courseId,
                              @PathVariable Integer page) {
        HmsCourse course = courseService.selectByClassIdAndCourseId(classId, courseId);
        Page<HmsHomework> homeworkPage =
                homeworkService.selectAllByCourseIdAndClassId(classId, courseId, page, 5);
        CourseDetailVo courseDetailVo = new CourseDetailVo();
        BeanUtils.copyProperties(course, courseDetailVo);
        courseDetailVo.setHomeworkPage(homeworkPage);
        return ApiResponse.ok(courseDetailVo);
    }

}
