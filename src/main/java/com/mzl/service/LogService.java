package com.mzl.service;

import com.mzl.bean.Log;

import java.util.List;

/**
 * @InterfaceName :   LogService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:04
 * @Version: 1.0
 */
public interface LogService {

    public Integer insertLog(Log log);

    public List<Log> selectLogListByLog(Log log);
}
