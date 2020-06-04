package com.mzl.service.impl;

import com.mzl.bean.Administrator;
import com.mzl.bean.PageBean;
import com.mzl.dao.AdministratorDao;
import com.mzl.service.AdministratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName :   AdministratorServiceImpl
 * @Description: 管理员接口实现
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:34
 * @Version: 1.0
 */
@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private AdministratorDao administratorDao;

    @Override
    public Administrator selectAdministratorById(String id) {
        // TODO 自动生成的方法存根
        Administrator administrator = administratorDao.selectAdministratorById(id);
        return administrator;
    }

    @Override
    public PageBean<Administrator> selectAdministratorListByPage(Administrator administrator, PageBean<Administrator> pageBean) {
        // TODO 自动生成的方法存根
        //查询分页结果
        pageBean.setResult(administratorDao.selectAdministratorListByPage(administrator, pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(administratorDao.selectTotal(administrator));
        return pageBean;
    }

    @Override
    public Integer updateAdministrator(Administrator administrator) {
        // TODO 自动生成的方法存根
        Integer i = administratorDao.updateAdministrator(administrator);
        return i;
    }

    @Override
    public Integer insertAdministrator(Administrator administrator) {
        Integer i = administratorDao.insertAdministrator(administrator);
        return i;
    }

    @Override
    public Integer deleteAdministratorById(String id) {
        Integer i = administratorDao.deleteAdministratorById(id);
        return i;
    }


}
