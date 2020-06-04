package com.mzl.service.impl;

import com.mzl.bean.PageBean;
import com.mzl.bean.Student;
import com.mzl.dao.StudentDao;
import com.mzl.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName :   StudentServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:37
 * @Version: 1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student selectStudentById(String id) {
        // TODO 自动生成的方法存根
        Student student = studentDao.selectStudentById(id);
        return student;
    }

    @Override
    public PageBean<Student> selectStudentListByPage(Student student, PageBean<Student> pageBean) {
        // TODO 自动生成的方法存根
        //查询分页结果
        pageBean.setResult(studentDao.selectStudentListByPage(student, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(studentDao.selectTotal(student));
        return pageBean;
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Integer deleteStudentById(String id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public Integer insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }
}
