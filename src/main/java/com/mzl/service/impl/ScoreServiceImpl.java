package com.mzl.service.impl;

import com.mzl.bean.PageBean;
import com.mzl.bean.Score;
import com.mzl.bean.TeacherCourse;
import com.mzl.dao.*;
import com.mzl.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName :   ScoreServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 10:20
 * @Version: 1.0
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreDao scoreDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private CourseDao courseDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private TeacherCourseDao teacherCourseDao;

    @Override
    public PageBean<Score> selectScoreListByPage(Score score, PageBean<Score> pageBean) {
        //分页查询
        pageBean.setResult(scoreDao.selectScoreListByPage(score, pageBean.getStart(), pageBean.getEnd()));
        //总记录数
        pageBean.setTotal(scoreDao.selectTotal(score));

        return pageBean;
    }

    @Override
    public Integer updateScore(Score score) {
        return scoreDao.updateScore(score);
    }

    @Override
    public Integer deleteScoreById(String studentId, String courseId) {
        return scoreDao.deleteScoreById(studentId, courseId);
    }

    @Override
    public Integer insertScore(Score score) {
        return scoreDao.insertScore(score);
    }

    @Override
    public PageBean<Map<String, Object>> selectScoreListByStudent(Score score, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Score> list = scoreDao.selectScoreListByPage(score, pageBean.getStart(), pageBean.getEnd());
        for (Score o : list){
            Map<String, Object> objs = new HashMap<String, Object>();
            objs.put("studentId", o.getStudentId());
            objs.put("courseId", o.getCourseId());
            objs.put("term", o.getTerm());
            objs.put("score", o.getScore());
            objs.put("studentName", studentDao.selectStudentById(o.getStudentId()).getName());
            objs.put("courseName", courseDao.selectCourseById(o.getCourseId()).getName());
            resultList.add(objs);
        }

        pageBean.setResult(resultList);
        //查询记录总数
        pageBean.setTotal(scoreDao.selectTotal(score));
        return pageBean;
    }

    @Override
    public PageBean<Map<String, Object>> selectScoreListByTeacher(String teacherId, Score score, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<TeacherCourse> list = teacherCourseDao.selectTeacherCourseListByTeacherId(teacherId);
        Set<String> set = new HashSet<String>();
        for(TeacherCourse o: list) {
            if(set.contains(o.getCourseId())) {
                continue;
            }
            set.add(o.getCourseId());
            score.setCourseId(o.getCourseId());
            List<Score> scoreList = scoreDao.selectScoreListByPage(score, pageBean.getStart(), pageBean.getEnd());
            for(Score s: scoreList) {
                Map<String, Object> objs = new HashMap<String, Object>();
                objs.put("studentId", s.getStudentId());
                objs.put("courseId", s.getCourseId());
                objs.put("term", s.getTerm());
                objs.put("score", s.getScore());
                objs.put("studentName", studentDao.selectStudentById(s.getStudentId()).getName());
                objs.put("courseName", courseDao.selectCourseById(o.getCourseId()).getName());
                objs.put("teacherId", teacherId);
                objs.put("teacherName", teacherDao.selectTeacherById(teacherId).getName());
                resultList.add(objs);
            }
        }
        pageBean.setResult(resultList);
        //查询记录总数
        pageBean.setTotal(scoreDao.selectTotal(score));
        return pageBean;
    }

}
