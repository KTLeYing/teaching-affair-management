<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/6/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>老师后台管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/layui/css/layui.css">
    <script src="<%=request.getContextPath() %>/static/jquery-easyui-1.3.5/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">老师后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/welcome.do');">首页</a></li>
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/course_list.do');">课程管理</a></li>
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/score_list.do');">成绩管理</a></li>
            <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/evaluation_list.do');">评价管理</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    ${id }
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/modify_password.do');">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath() %>/logout.do">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/course_list.do');">课程管理</a></li>
                <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/score_list.do');">成绩管理</a></li>
                <li class="layui-nav-item"><a href="javascript:$('#iframe').attr('src','<%=request.getContextPath() %>/teacher/evaluation_list.do');">评价管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframe" src="<%=request.getContextPath() %>/teacher/welcome.do"
                frameborder="0" width="100%" scrolling="no" height="100%">
            <p>您的浏览器不支持  iframe 标签。</p>
        </iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        Academic-Teaching-Affair-Management-System
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