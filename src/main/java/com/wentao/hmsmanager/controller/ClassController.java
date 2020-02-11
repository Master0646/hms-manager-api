package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsUser;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.service.UserService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private UserService userService;

    /**
     * 获取所在班级的信息
     */
    @GetMapping("/api/v1/class/{id}")
    public ApiResponse info(@PathVariable Integer id) {
        HmsUser user = userService.findById(id);
        List<HmsClass> classInfo = user.getHmsClass();
        return ApiResponse.ok(classInfo);
    }

}
