package com.mzl.service.impl;

import com.mzl.bean.Evaluation;
import com.mzl.bean.PageBean;
import com.mzl.bean.TeacherCourse;
import com.mzl.dao.*;
import com.mzl.service.EvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName :   EvaluationServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 11:13
 * @Version: 1.0
 */
@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {

    @Resource
    private EvaluationDao evaluationDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private CourseDao courseDao;
    @Resource
    private TeacherCourseDao teacherCourseDao;

    @Override
    public PageBean<Evaluation> selectEvaluationListByPage(com.mzl.bean.Evaluation evaluation, PageBean<com.mzl.bean.Evaluation> pageBean) {
        // TODO 自动生成的方法存根
        //查询分页结果
        pageBean.setResult(evaluationDao.selectEvaluationListByPage(evaluation, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(evaluationDao.selectTotal(evaluation));
        return pageBean;
    }


    @Override
    public Integer updateEvaluation(Evaluation evaluation) {
        return evaluationDao.updateEvaluation(evaluation);
    }

    @Override
    public Integer deleteEvaluationById(String studentId, String courseId) {
        return evaluationDao.deleteEvaluationById(studentId, courseId);
    }

    @Override
    public Integer insertEvaluation(Evaluation evaluation) {
        return evaluationDao.insertEvaluation(evaluation);
    }

    @Override
    public PageBean<Map<String, Object>> selectEvaluationListByStudent(Evaluation evaluation, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Evaluation> list = evaluationDao.selectEvaluationListByPage(evaluation, pageBean.getStart(), pageBean.getEnd());
        for(Evaluation o: list) {
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
        pageBean.setTotal(evaluationDao.selectTotal(evaluation));
        return pageBean;
    }

    @Override
    public PageBean<Map<String, Object>> selectEvaluationListByTeacher(String teacherId, Evaluation evaluation, PageBean<Map<String, Object>> pageBean) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<TeacherCourse> list = teacherCourseDao.selectTeacherCourseListByTeacherId(teacherId);
        System.out.println(list);
        Set<String> set = new HashSet<String>();
        for(TeacherCourse o: list) {
            if(set.contains(o.getCourseId())) {
                continue;
            }
            set.add(o.getCourseId());
            System.out.println(set);
            evaluation.setCourseId(o.getCourseId());
            List<Evaluation> scoreList = evaluationDao.selectEvaluationListByPage(evaluation, pageBean.getStart(), pageBean.getEnd());
            for(Evaluation s: scoreList) {
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
        pageBean.setTotal(evaluationDao.selectTotal(evaluation));
        return pageBean;
    }


}
