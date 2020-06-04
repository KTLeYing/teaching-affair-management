package com.mzl.dao;

import com.mzl.bean.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :   AdministratorDao
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/2 11:49
 * @Version: 1.0
 */
public interface AdministratorDao {

    public Administrator selectAdministratorById(String id);

    public List<Administrator> selectAdministratorList();

    public List<Administrator> selectAdministratorListByPage(@Param("administrator") Administrator administrator, @Param("start") Integer start, @Param("end") Integer end);

    public Long selectTotal(Administrator administrator);

    public Integer updateAdministrator(Administrator administrator);

    public Integer insertAdministrator(Administrator administrator);

    public Integer deleteAdministratorById(String id);
}
