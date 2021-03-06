<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/6/2
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员后台管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/layui/css/layui.css">
    <script src="<%=request.getContextPath() %>/static/jquery-easyui-1.3.5/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/welcome.do');">首页</a></li>
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/welcome.do');">控制台</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/admin_list.do');">管理员</a></dd>
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/teacher_list.do');">老师</a></dd>
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/student_list.do');">学生</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">课程管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/course_list.do');">课程列表</a></dd>
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/teacher_course_list.do');">老师课程列表</a></dd>
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/student_course_list.do');">学生课程列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/score_list.do');">成绩管理</a></dd>
                    <dd><a href="javascript:javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/evaluation_list.do');">评价管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    ${id}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/modify_password.do');">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath() %>/logout.do">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/admin_list.do');">管理员</a></dd>
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/teacher_list.do');">老师</a></dd>
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/student_list.do');">学生</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/course_list.do');">课程列表</a></dd>
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/teacher_course_list.do');">老师课程列表</a></dd>
                        <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/student_course_list.do');">学生课程列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/score_list.do');">成绩管理</a></li>
                <li class="layui-nav-item"><a href="javascript:javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/admin/evaluation_list.do');">评价管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframe" src="<%=request.getContextPath() %>/admin/welcome.do"
                frameborder="0" width="100%" scrolling="no" height="100%">
            <p>您的浏览器不支持  iframe 标签。</p>
        </iframe>
    </div>

    <div class="layui-footer" align="center">
        <!-- 底部固定区域 -->
       Copyright © 2020 MZL. @教务管理系统.
    </div>
</div>
<script src="<%=request.getContextPath() %>/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
