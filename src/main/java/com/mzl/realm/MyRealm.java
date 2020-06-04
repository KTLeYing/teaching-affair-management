package com.mzl.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.mzl.bean.Administrator;
import com.mzl.bean.Student;
import com.mzl.bean.Teacher;
import com.mzl.service.AdministratorService;
import com.mzl.service.StudentService;
import com.mzl.service.TeacherService;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm{

    @Resource
    private AdministratorService administratorService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    /**
     * 为当前登陆的用户授予角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String id = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<String> roleNames = new HashSet<String>();
        // 根据用户名查询当前用户权限
        Set<String> permissionNames = new HashSet<String>();
        
        Administrator administrator = administratorService.selectAdministratorById(id); //重数据库查询用户信息
        if (administrator != null) {
            roleNames.add("admin");
            permissionNames.add("admin");
        }
        Teacher teacher = teacherService.selectTeacherById(id); //重数据库查询用户信息
        if (teacher != null) {
            roleNames.add("teacher");
            permissionNames.add("teacher");
        }
        Student student = studentService.selectStudentById(id); //重数据库查询用户信息
        if (student != null) {
            roleNames.add("student");
            permissionNames.add("student");
        }

        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionNames);

        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String id = (String) authenticationToken.getPrincipal(); //获取用户名

        Administrator administrator = administratorService.selectAdministratorById(id); //重数据库查询用户信息
        if (administrator != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    administrator.getId(), administrator.getPassword(), getName());
            SecurityUtils.getSubject().getSession().setAttribute("id", administrator.getId()); //把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("no", "0");
            return authcInfo;
        }
        Teacher teacher = teacherService.selectTeacherById(id); //重数据库查询用户信息
        if (teacher != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    teacher.getId(), teacher.getPassword(), getName());
            SecurityUtils.getSubject().getSession().setAttribute("id", teacher.getId()); //把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("no", "1");
            return authcInfo;
        }
        Student student = studentService.selectStudentById(id); //重数据库查询用户信息
        if (student != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    student.getId(), student.getPassword(), getName());
            SecurityUtils.getSubject().getSession().setAttribute("id", student.getId()); //把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("no", "2");
            return authcInfo;
        }
        return null;
    }
}
