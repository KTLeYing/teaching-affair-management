package com.mzl.controller.student;

import com.alibaba.fastjson.JSONObject;
import com.mzl.bean.Student;
import com.mzl.log.Log;
import com.mzl.service.LogService;
import com.mzl.service.StudentService;
import com.mzl.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @ClassName :   StudentController
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/4 12:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private LogService logService;
    @Resource
    private StudentService studentService;

    @Log(module = "学生后台", method = "学生后台")
    @RequestMapping("/student_index")
    public String studentIndex() {

        return "student/student_index";
    }

    @Log(module = "学生后台", method = "修改密码页面")
    @RequestMapping("/modify_password")
    public String modifyPassword() {

        return "student/modify_password";
    }

    @Log(module = "学生后台", method = "修改密码")
    @RequestMapping("/update_password")
    public String updatePassword(
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestParam(value = "oldPassword", required = false) String oldPassword,
            @RequestParam(value = "newPassword", required = false) String newPassword,
            HttpServletResponse response) throws Exception {

        System.out.println(studentId);
        System.out.println(oldPassword);
        System.out.println(newPassword);

        Student student = studentService.selectStudentById(studentId);

        System.out.println("jjjj");
        System.out.println(student.getPassword());

        if(student.getPassword().equals(oldPassword)) {
            student.setPassword(newPassword);
            studentService.updateStudent(student);
            System.out.println("oooo");

            //使用阿里巴巴的fastJson创建JSONObject
            JSONObject result = new JSONObject();
            //将序列化结果放入json对象中
            result.put("success", true);

            //使用自定义工具类向response中写入数据
            ResponseUtil.write(response, result);
        }

        return null;
    }


    @Log(module = "学生后台", method = "获取欢迎数据")
    @RequestMapping("/select_welcome")
    public String selectWelcome(
            @RequestParam(value = "studentId", required = false) String studentId,
            HttpServletResponse response) throws Exception {

        Student student = studentService.selectStudentById(studentId);
        com.mzl.bean.Log log = new com.mzl.bean.Log();
        log.setUserId(studentId);
        log.setMethod("登陆成功");
        List<com.mzl.bean.Log> list = logService.selectLogListByLog(log);

        System.out.println(log.getUserId());
        System.out.println(list);

        //使用阿里巴巴的fastJson创建JSONObject
        JSONObject result = new JSONObject();
        //将序列化结果放入json对象中
        result.put("name", student.getName());
        result.put("cnt", list.size());
        if(list.size() > 1) {
            Map<String, Object> time = new HashMap<>();
            Date date = list.get(1).getTime();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            // y, M, d, H, m, s
            time.put("y", c.get(Calendar.YEAR));
            time.put("M", c.get(Calendar.MONTH));
            time.put("d", c.get(Calendar.DAY_OF_MONTH));
            time.put("H", c.get(Calendar.HOUR_OF_DAY));
            time.put("m", c.get(Calendar.MINUTE));
            time.put("s", c.get(Calendar.SECOND));
            result.put("time", time);
        }

        //使用自定义工具类向response中写入数据
        ResponseUtil.write(response, result);
        return null;
    }

    @Log(module = "学生后台", method = "欢迎页面")
    @RequestMapping("/welcome")
    public String welcome() {

        return "student/welcome";
    }




}
