package com.mzl.dao;

import com.mzl.bean.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   ScoreDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 10:21
 * @Version: 1.0
 */
public interface ScoreDao {
    
    public List<Score> selectScoreListByPage(@Param("score") Score score, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Score score);

    public Integer updateScore(Score score);

    public Integer deleteScoreById(@Param("studentId") String studentId, @Param("courseId") String courseId);

    public Integer insertScore(Score score);
}
