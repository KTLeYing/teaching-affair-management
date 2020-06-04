package com.mzl.service;

import com.mzl.bean.PageBean;
import com.mzl.bean.Teacher;

/**
 * @InterfaceName :   TeacherService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:09
 * @Version: 1.0
 */
public interface TeacherService {

    public Teacher selectTeacherById(String id);

    public PageBean<Teacher> selectTeacherListByPage(Teacher teacher, PageBean<Teacher> pageBean);

    public Integer updateTeacher(Teacher teacher);

    public Integer deleteTeacherById(String id);

    public Integer insertTeacher(Teacher teacher);
}
