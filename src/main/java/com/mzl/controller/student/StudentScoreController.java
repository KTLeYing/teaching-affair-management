package com.mzl.controller.student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mzl.bean.PageBean;
import com.mzl.bean.Score;
import com.mzl.log.Log;
import com.mzl.service.ScoreService;
import com.mzl.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName :   StudentScoreController
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 15:18
 * @Version: 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentScoreController {

    @Resource
    private ScoreService scoreService;

    @Log(module = "学生后台", method = "成绩列表页面")
    @RequestMapping("/score_list")
    public String scoreList() {

        return "student/score_list";
    }

    @Log(module = "学生后台", method = "获取成绩列表")
    @RequestMapping("/select_score_list")
    public String selectScoreList(
            Score score,
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "limit", required = false) String limit,
            HttpServletResponse response) throws Exception {

        //定义分页
        PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>(
                Integer.parseInt(page),
                Integer.parseInt(limit));
        //拿到分页结果已经记录总数的page
        pageBean = scoreService.selectScoreListByStudent(score, pageBean);

        //使用阿里巴巴的fastJson创建JSONObject
        JSONObject result = new JSONObject();
        //通过fastJson序列化list为jsonArray
        String jsonArray = JSON.toJSONString(pageBean.getResult());
        JSONArray array = JSONArray.parseArray(jsonArray);
        //将序列化结果放入json对象中
        result.put("data", array);
        result.put("count", pageBean.getTotal());
        result.put("code", 0);

        //使用自定义工具类向response中写入数据
        ResponseUtil.write(response, result);
        return null;
    }



}
