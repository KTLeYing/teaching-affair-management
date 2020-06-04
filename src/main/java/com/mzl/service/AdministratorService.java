package com.mzl.service;

import com.mzl.bean.Administrator;
import com.mzl.bean.PageBean;

/**
 * @InterfaceName :   AdministratorService
 * @Description: 管理员
 * @Author: 21989
 * @CreateDate: 2020/6/2 12:09
 * @Version: 1.0
 */
public interface AdministratorService {

    public Administrator selectAdministratorById(String id);

    public PageBean<Administrator> selectAdministratorListByPage(Administrator administrator, PageBean<Administrator> pageBean);

    public Integer updateAdministrator(Administrator administrator);

    public Integer insertAdministrator(Administrator administrator);

    public Integer deleteAdministratorById(String id);
}
