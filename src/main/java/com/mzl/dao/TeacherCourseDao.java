package com.mzl.dao;

import com.mzl.bean.TeacherCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   TeacherCourseDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 18:47
 * @Version: 1.0
 */
public interface TeacherCourseDao {

    public List<TeacherCourse> selectTeacherCourseListByPage(@Param("teacherCourse") TeacherCourse teacherCourse, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(TeacherCourse teacherCourse);

    public Integer updateTeacherCourse(TeacherCourse teacherCourse);

    public Integer deleteTeacherCourseById(Integer id);

    public Integer insertTeacherCourse(TeacherCourse teacherCourse);

    public List<TeacherCourse> selectTeacherCourseListByTeacherId(String teacherId);
}
