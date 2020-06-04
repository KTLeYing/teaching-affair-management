package com.mzl.dao;

import com.mzl.bean.Evaluation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   EvaluationDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 11:14
 * @Version: 1.0
 */
public interface EvaluationDao {


    public List<Evaluation> selectEvaluationListByPage(@Param("evaluation") Evaluation evaluation, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Evaluation evaluation);

    public Integer updateEvaluation(Evaluation evaluation);

    public Integer deleteEvaluationById(@Param("studentId") String studentId, @Param("courseId") String courseId);

    public Integer insertEvaluation(Evaluation evaluation);
}
