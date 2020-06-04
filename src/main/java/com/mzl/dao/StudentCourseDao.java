package com.mzl.dao;

import com.mzl.bean.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   StudentCourseDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 9:08
 * @Version: 1.0
 */
public interface StudentCourseDao {

    public List<StudentCourse> selectStudentCourseListByPage(@Param("studentCourse") StudentCourse studentCourse, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(StudentCourse studentCourse);

    public Integer updateStudentCourse(StudentCourse studentCourse);

    public Integer deleteStudentCourseById(String id);

    public Integer insertStudentCourse(StudentCourse studentCourse);
}
