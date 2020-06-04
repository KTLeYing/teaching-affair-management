package com.mzl.dao;

import com.mzl.bean.Course;
import com.mzl.bean.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   CourseDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 1:11
 * @Version: 1.0
 */
public interface CourseDao {

    public List<Course> selectCourseListByPage(@Param("course") Course course, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Course course);

    public Integer updateCourse(Course course);

    public Integer deleteCourseById(String id);

    public Integer insertCourse(Course course);

    public Course selectCourseById(String courseId);
}
