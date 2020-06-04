package com.mzl.service.impl;

import com.mzl.bean.PageBean;
import com.mzl.bean.StudentCourse;
import com.mzl.dao.CourseDao;
import com.mzl.dao.StudentCourseDao;
import com.mzl.dao.StudentDao;
import com.mzl.service.StudentCourseService;
import com.mzl.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   StudentCourseService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 9:07
 * @Version: 1.0
 */
@Service("studentCourseService")
public class StudentCourseServiceImpl implements StudentCourseService {

    @Resource
    private StudentCourseDao studentCourseDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private CourseDao courseDao;

    @Override
    public PageBean<StudentCourse> selectStudentCourseListByPage(StudentCourse studentCourse, PageBean<StudentCourse> pageBean) {
        //查询分页结果
        pageBean.setResult(studentCourseDao.selectStudentCourseListByPage(studentCourse, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(studentCourseDao.selectTotal(studentCourse));

        return pageBean;
    }

    @Override
    public Integer updateStudentCourse(StudentCourse studentCourse) {
        return studentCourseDao.updateStudentCourse(studentCourse);
    }

    @Override
    public Integer deleteStudentCourseById(String id) {
        return studentCourseDao.deleteStudentCourseById(id);
    }

    @Override
    public Integer insertStudentCourse(StudentCourse studentCourse) {
        return studentCourseDao.insertStudentCourse(studentCourse);
    }

    @Override
    public PageBean<Map<String, Object>> selectStudentCourseList(StudentCourse studentCourse, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<StudentCourse> list = studentCourseDao.selectStudentCourseListByPage(studentCourse, pageBean.getStart(), pageBean.getEnd());
        for(StudentCourse o: list) {
            Map<String, Object> objs = new HashMap<String, Object>();
            objs.put("id", o.getId());
            objs.put("studentId", o.getStudentId());
            objs.put("courseId", o.getCourseId());
            objs.put("term", o.getTerm());
            objs.put("information", o.getInformation());
            objs.put("studentName", studentDao.selectStudentById(o.getStudentId()).getName());
            objs.put("courseName", courseDao.selectCourseById(o.getCourseId()).getName());
            resultList.add(objs);
        }
        System.out.println("gggg");
        System.out.println(resultList);

        pageBean.setResult(resultList);
        //查询记录总数
        pageBean.setTotal(studentCourseDao.selectTotal(studentCourse));
        return pageBean;
    }



}
