package com.mzl.service;

import com.mzl.bean.PageBean;
import com.mzl.bean.Student;

/**
 * @InterfaceName :   StudentService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:09
 * @Version: 1.0
 */
public interface StudentService {

    public Student selectStudentById(String id);

    public PageBean<Student> selectStudentListByPage(Student student, PageBean<Student> pageBean);

    public Integer updateStudent(Student student);

    public Integer deleteStudentById(String id);

    public Integer insertStudent(Student student);
}
