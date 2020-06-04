package com.mzl.service.impl;

import com.mzl.bean.Log;
import com.mzl.dao.LogDao;
import com.mzl.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :   LogServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:36
 * @Version: 1.0
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Resource
    private LogDao logDao;

    @Override
    public Integer insertLog(Log log) {
        // TODO 自动生成的方法存根
        Integer i = logDao.insertLog(log);
        return i;
    }

    @Override
    public List<Log> selectLogListByLog(Log log) {
        List<Log> list = logDao.selectLogListByLog(log);
        return list;
    }


}
