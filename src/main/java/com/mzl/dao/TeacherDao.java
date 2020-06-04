package com.mzl.dao;

import com.mzl.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   TeacherDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 16:32
 * @Version: 1.0
 */
public interface TeacherDao {

    public List<Teacher> selectTeacherListByPage(@Param("teacher") Teacher teacher, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Teacher teacher);

    public Integer updateTeacher(Teacher teacher);

    public Integer deleteTeacherById(String id);

    public Integer insertTeacher(Teacher teacher);

    public Teacher selectTeacherById(String id);
}
