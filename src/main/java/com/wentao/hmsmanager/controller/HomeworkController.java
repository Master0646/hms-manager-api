package com.wentao.hmsmanager.controller;

import com.wentao.hmsmanager.entity.HmsClass;
import com.wentao.hmsmanager.entity.HmsCourse;
import com.wentao.hmsmanager.entity.HmsHomework;
import com.wentao.hmsmanager.service.ClassService;
import com.wentao.hmsmanager.service.CourseService;
import com.wentao.hmsmanager.service.HomeworkService;
import com.wentao.hmsmanager.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;
    @Autowired
    CourseService courseService;
    @Autowired
    ClassService classService;

    private static final String pathPattern = "./upload/%s/%s";

    @GetMapping("/api/v1/homework/{id}")
    public ApiResponse info(@PathVariable Integer id) {
        HmsCourse course = courseService.findById(id);
        List<HmsHomework> homeworks = course.getHomeworks();
        return ApiResponse.ok(homeworks);
    }

    @PostMapping("/api/v1/homework/upload")
    public ApiResponse upload(HttpServletRequest request) {

        return ApiResponse.ok();
    }

    /**
     * 发布作业到指定班级
     *
     * @param classId    班级id
     * @param homeworkId 作业id
     * @return Api执行结果
     */
    @PostMapping("/api/v1/homework/release")
    public ApiResponse release(@RequestBody Integer classId, Integer homeworkId) {
        HmsClass hmsClass = classService.findById(classId);
        homeworkService.save(hmsClass, homeworkId);
        return ApiResponse.ok(hmsClass);
    }

    /**
     * 创建作业
     *
     * @param request multipart请求
     * @return Api执行结果
     */
    @PostMapping("/api/v1/homework/create")
    public ApiResponse create(HttpServletRequest request) {
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");

        Integer courseId = Integer.valueOf(params.getParameter("courseId"));
        HmsHomework homework = new HmsHomework();
        String title = params.getParameter("title");
        String description = params.getParameter("description");
        homework.setTitle(title);
        homework.setDescription(description);

        HmsCourse course = courseService.findById(courseId);


        String fileName = String.format(pathPattern, courseId, title);
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(fileName)));
                    stream.write(bytes);
                } catch (Exception e) {
                    stream = null;
                    e.printStackTrace();
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        homework.setContent(fileName);
        HmsHomework save = homeworkService.save(course, homework);
        return ApiResponse.ok(save);
    }

}
