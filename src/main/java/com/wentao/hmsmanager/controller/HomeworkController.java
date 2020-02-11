package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.entity.HmsHomework;
import com.wentao.hmsmanager.service.CourseService;
import com.wentao.hmsmanager.service.HomeworkService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;
    @Autowired
    CourseService courseService;

    @GetMapping("/api/v1/homework/{id}")
    public ApiResponse info(@PathVariable Integer id) {
        HmsCourse course = courseService.findById(id);
        List<HmsHomework> homeworks = course.getHomeworks();
        return ApiResponse.ok(homeworks);
    }

    @PostMapping("/api/v1/homework/upload")
    public ApiResponse upload(Integer id, MultipartFile file) {

        return ApiResponse.ok();
    }

    /**
     * 教师发布作业
     * 上传附件及提交表单信息
     * 将为这份作业创建对应的文件夹目录
     *
     * @param request 从请求中获取multipart/formData的内容
     * @return Api执行结果
     */
    @PostMapping("/api/v1/homework/release")
    public ApiResponse release(HttpServletRequest request) {
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;

        return ApiResponse.ok();
    }

}
