package com.mzl.service.impl;

import com.mzl.bean.PageBean;
import com.mzl.bean.Student;
import com.mzl.bean.Teacher;
import com.mzl.dao.TeacherDao;
import com.mzl.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName :   TeacherServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:39
 * @Version: 1.0
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    @Override
    public Teacher selectTeacherById(String id) {
        Teacher teacher = teacherDao.selectTeacherById(id);
        return teacher;
    }

    @Override
    public PageBean<Teacher> selectTeacherListByPage(Teacher teacher, PageBean<Teacher> pageBean) {
        // TODO 自动生成的方法存根
        //查询分页结果
        pageBean.setResult(teacherDao.selectTeacherListByPage(teacher, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(teacherDao.selectTotal(teacher));
        return pageBean;
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public Integer deleteTeacherById(String id) {
        return teacherDao.deleteTeacherById(id);
    }

    @Override
    public Integer insertTeacher(Teacher teacher) {
        return teacherDao.insertTeacher(teacher);
    }


}
