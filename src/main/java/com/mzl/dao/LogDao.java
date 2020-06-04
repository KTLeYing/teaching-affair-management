package com.mzl.dao;

import com.mzl.bean.Log;

import java.util.List;

/**
 * @InterfaceName :   LogDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 17:44
 * @Version: 1.0
 */
public interface LogDao {

    public List<Log> selectLogList();

    public List<Log> selectLogListByLog(Log log);

    public Integer insertLog(Log log);
}
