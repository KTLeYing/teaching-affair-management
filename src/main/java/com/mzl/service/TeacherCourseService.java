package com.mzl.service;

import com.mzl.bean.PageBean;
import com.mzl.bean.TeacherCourse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @InterfaceName :   TeacherCourseService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 18:46
 * @Version: 1.0
 */
public interface TeacherCourseService {

    public PageBean<TeacherCourse> selectTeacherCourseListByPage(TeacherCourse teacherCourse, PageBean<TeacherCourse> pageBean);

    public Integer updateTeacherCourse(TeacherCourse teacherCourse);

    public Integer deleteTeacherCourseById(Integer id);

    public Integer insertTeacherCourse(TeacherCourse teacherCourse);

    public PageBean<Map<String, Object>> selectTeacherCourseList(TeacherCourse teacherCourse, PageBean<Map<String, Object>> pageBean);
}
