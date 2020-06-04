package com.mzl.service;

import com.mzl.bean.PageBean;
import com.mzl.bean.StudentCourse;

import java.util.Map;

/**
 * @InterfaceName :   StudentCourseService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 9:07
 * @Version: 1.0
 */
public interface StudentCourseService {

    public PageBean<StudentCourse> selectStudentCourseListByPage(StudentCourse studentCourse, PageBean<StudentCourse> pageBean);

    public Integer updateStudentCourse(StudentCourse studentCourse);

    public Integer deleteStudentCourseById(String id);

    public Integer insertStudentCourse(StudentCourse studentCourse);

    public PageBean<Map<String, Object>> selectStudentCourseList(StudentCourse studentCourse, PageBean<Map<String, Object>> pageBean);
}
