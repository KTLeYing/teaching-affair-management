package com.mzl.service.impl;

import com.mzl.bean.PageBean;
import com.mzl.bean.TeacherCourse;
import com.mzl.dao.CourseDao;
import com.mzl.dao.TeacherCourseDao;
import com.mzl.dao.TeacherDao;
import com.mzl.service.TeacherCourseService;
import com.mzl.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   TeacherCourseServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 18:47
 * @Version: 1.0
 */
@Service("teacherCourseService")
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Resource
    private TeacherCourseDao teacherCourseDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private CourseDao courseDao;

    @Override
    public PageBean<TeacherCourse> selectTeacherCourseListByPage(TeacherCourse teacherCourse, PageBean<TeacherCourse> pageBean) {
        //查询分页结果
        pageBean.setResult(teacherCourseDao.selectTeacherCourseListByPage(teacherCourse, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(teacherCourseDao.selectTotal(teacherCourse));
        return pageBean;
    }

    @Override
    public Integer updateTeacherCourse(TeacherCourse teacherCourse) {
        return teacherCourseDao.updateTeacherCourse(teacherCourse);
    }

    @Override
    public Integer deleteTeacherCourseById(Integer id) {
        return teacherCourseDao.deleteTeacherCourseById(id);
    }

    @Override
    public Integer insertTeacherCourse(TeacherCourse teacherCourse) {
        return teacherCourseDao.insertTeacherCourse(teacherCourse);
    }

    @Override
    public PageBean<Map<String, Object>> selectTeacherCourseList(TeacherCourse teacherCourse, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<TeacherCourse> list = teacherCourseDao.selectTeacherCourseListByPage(teacherCourse, pageBean.getStart(), pageBean.getEnd());
        System.out.println(list.size());
        System.out.println(list);
        for(TeacherCourse o : list) {
            Map<String, Object> objs = new HashMap<String, Object>();
            objs.put("id", o.getId());
            objs.put("teacherId", o.getTeacherId());
            objs.put("courseId", o.getCourseId());
            objs.put("term", o.getTerm());
            objs.put("information", o.getInformation());
            objs.put("teacherName", teacherDao.selectTeacherById(o.getTeacherId()).getName());
            objs.put("courseName", courseDao.selectCourseById(o.getCourseId()).getName());
            resultList.add(objs);
            System.out.println(objs);
        }
        System.out.println(resultList);
        System.out.println("sssss");
        pageBean.setResult(resultList);
        System.out.println("wwww");
        //查询记录总数
        pageBean.setTotal(teacherCourseDao.selectTotal(teacherCourse));
        return pageBean;
    }


}
