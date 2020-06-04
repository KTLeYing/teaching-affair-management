package com.mzl.service;

import com.mzl.bean.Evaluation;
import com.mzl.bean.PageBean;

import java.util.Map;

/**
 * @InterfaceName :   EvaluationService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 11:13
 * @Version: 1.0
 */
public interface EvaluationService {

    public PageBean<Evaluation> selectEvaluationListByPage(Evaluation evaluation, PageBean<Evaluation> pageBean);

    public Integer updateEvaluation(Evaluation evaluation);

    public Integer deleteEvaluationById(String studentId, String courseId);

    public Integer insertEvaluation(Evaluation evaluation);

    public PageBean<Map<String, Object>> selectEvaluationListByStudent(Evaluation evaluation, PageBean<Map<String, Object>> pageBean);

    public PageBean<Map<String, Object>> selectEvaluationListByTeacher(String teacherId, Evaluation evaluation, PageBean<Map<String, Object>> pageBean);
}
