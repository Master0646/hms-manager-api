package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.entity.HmsHomework;
import com.wentao.hmsmanager.entity.vo.CourseDetailVo;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.service.CourseService;
import com.wentao.hmsmanager.service.HomeworkService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    private ClassService classService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/api/v1/course/{id}")
    public ApiResponse info(@PathVariable Integer id) {
        HmsClass hmsClass = classService.findById(id);
        Set<HmsCourse> info = hmsClass.getCourses();
        return ApiResponse.ok(info);
    }

    @GetMapping("/api/v1/course/detail/{classId}/{courseId}/{page}")
    public ApiResponse detail(@PathVariable Integer classId,
                              @PathVariable Integer courseId,
                              @PathVariable Integer page) {
        HmsClass hmsClass = classService.findById(classId);
        HmsCourse course = courseService.findById(courseId);
        Page<HmsHomework> homeworkPage =
                homeworkService.findAllByCourseAndClass(hmsClass, course, page - 1, 5);
        CourseDetailVo courseDetailVo = new CourseDetailVo();
        BeanUtils.copyProperties(course, courseDetailVo);
        courseDetailVo.setHomeworkPage(homeworkPage);
        return ApiResponse.ok(courseDetailVo);
    }

}
