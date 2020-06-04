package com.mzl.service;

import com.mzl.bean.PageBean;
import com.mzl.bean.Score;

import java.util.Map;

/**
 * @InterfaceName :   ScoreService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 10:19
 * @Version: 1.0
 */
public interface ScoreService {

    public PageBean<Score> selectScoreListByPage(Score score, PageBean<Score> pageBean);

    public Integer updateScore(Score score);

    public Integer deleteScoreById(String studentId, String courseId);

    public Integer insertScore(Score score);

    public PageBean<Map<String, Object>> selectScoreListByStudent(Score score, PageBean<Map<String, Object>> pageBean);

    public PageBean<Map<String, Object>> selectScoreListByTeacher(String teacherId, Score score, PageBean<Map<String, Object>> pageBean);
}
