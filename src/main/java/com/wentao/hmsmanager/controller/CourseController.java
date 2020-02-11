package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.service.CourseService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassService classService;

    @GetMapping("/api/v1/course/{id}")
    public ApiResponse info(@RequestParam @PathVariable Integer id) {
        HmsClass hmsClass = classService.findById(id);
        Set<HmsCourse> info = hmsClass.getCourses();
        return ApiResponse.ok(info);
    }

}
