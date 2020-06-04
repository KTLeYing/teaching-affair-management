package com.mzl.service.impl;

import com.mzl.bean.Course;
import com.mzl.bean.PageBean;
import com.mzl.dao.CourseDao;
import com.mzl.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName :   CourseServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/3 1:08
 * @Version: 1.0
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDao courseDao;

    @Override
    public PageBean<Course> selectCourseListByPage(Course course, PageBean<Course> pageBean) {
        // TODO 自动生成的方法存根
        //查询分页结果
        pageBean.setResult(courseDao.selectCourseListByPage(course, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(courseDao.selectTotal(course));

        return pageBean;
    }

    @Override
    public Integer updateCourse(Course course) {
        // TODO 自动生成的方法存根
        Integer i = courseDao.updateCourse(course);
        return i;
    }

    @Override
    public Integer deleteCourseById(String id) {
        // TODO 自动生成的方法存根
        Integer i = courseDao.deleteCourseById(id);
        return i;
    }

    @Override
    public Integer insertCourse(Course course) {
        // TODO 自动生成的方法存根
        Integer i = courseDao.insertCourse(course);
        return i;
    }
}
