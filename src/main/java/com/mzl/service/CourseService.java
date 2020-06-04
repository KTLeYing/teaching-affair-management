package com.mzl.service;

import com.mzl.bean.Course;
import com.mzl.bean.PageBean;

/**
 * @InterfaceName :   CourseService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 1:08
 * @Version: 1.0
 */
public interface CourseService {

    //分页查询
    public PageBean<Course> selectCourseListByPage(Course course, PageBean<Course> pageBean);

    public Integer updateCourse(Course course);

    public Integer deleteCourseById(String id);

    public Integer insertCourse(Course course);
}
