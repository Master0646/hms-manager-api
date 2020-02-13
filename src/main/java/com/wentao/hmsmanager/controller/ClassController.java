package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.pojo.HmsClass;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    /**
     * 获取所在班级的信息
     */
    @GetMapping("/api/v1/class/{id}")
    public ApiResponse info(@PathVariable Integer id) {
        List<HmsClass> classes = classService.selectByUserId(id);
        return ApiResponse.ok(classes);
    }

}
