package com.mzl.dao;

import com.mzl.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   StudentDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 17:43
 * @Version: 1.0
 */
public interface StudentDao {
    
    public List<Student> selectStudentListByPage(@Param("student") Student student, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Student student);

    public Integer updateStudent(Student student);

    public Integer deleteStudentById(String id);

    public Integer insertStudent(Student student);

    public Student selectStudentById(String id);
}
