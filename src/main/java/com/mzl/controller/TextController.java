package com.mzl.controller;

import com.mzl.log.Log;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName :   TextController
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 15:32
 * @Version: 1.0
 */
public class TextController {

    @Log(module = "前台", method = "异常页面")
    @RequestMapping("error")
    public String error() throws Exception {
        throw new Exception("异常测试");
    }

}
