<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/6/2
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/layui/css/layui.css"  media="all">
    <script src="<%=request.getContextPath() %>/static/jquery-easyui-1.3.5/jquery.min.js"></script>
</head>
<body style="margin: 15px;">

<div class="demoTable">
    <span>管理员用户：</span>
    <button class="layui-btn" data-type="insertAdmin">添加管理员</button>
    <div class="layui-inline">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-inline">
            <input type="text" id="s_id" class="layui-input">
        </div>
    </div>
    <button class="layui-btn" data-type="searchAdmin">搜索列表</button>
    <button class="layui-btn" data-type="refreshAdmin">还原默认</button>
</div>

<table class="layui-table" lay-data="{height:471, limit: 10, url:'<%=request.getContextPath() %>/admin/select_admin_list.do', page:true, id:'idTest'}" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{field:'id', width:250, sort: true, fixed: true}">ID</th>
        <th lay-data="{field:'id', width:250, sort: true}">用户名</th>
        <th lay-data="{field:'password', width:250, sort: true}">密码</th>
        <th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>


<script src="<%=request.getContextPath() %>/static/layui/layui.js" charset="utf-8"></script>

<script>
    var updateObj, updateIndex;
    function updateAdmin(){
        var load = layer.load();
        $.ajax({
            url:'<%=request.getContextPath() %>/admin/update_admin.do',
            type:'GET',
            async:false,    //是否异步
            data:{
                id:$("#id").val(),
                password:$("#password").val()
            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(result){
                if(result.success){
                    layer.msg('修改成功', {icon: 1});
                    updateObj.update({
                        id:$("#id").val(),
                        password:$("#password").val()
                    });
                } else{
                    layer.msg('修改失败', {icon: 2});
                }
            },
            error:function(xhr,textStatus){
                layer.msg('修改失败', {icon: 2});
            }
        });
        layer.close(updateIndex);
        layer.close(load);
    }

    var insertIndex;
    function insertAdmin(){
        var load = layer.load();
        $.ajax({
            url:'<%=request.getContextPath() %>/admin/insert_admin.do',
            type:'GET',
            async:false,    //是否异步
            data:{
                id:$("#id").val(),
                password:$("#password").val()
            },
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(result){
                if(result.success){
                    layer.msg('添加成功', {icon: 1});
                    layui.table.reload('idTest',{});
                } else{
                    layer.msg('添加失败', {icon: 2});
                }
            },
            error:function(xhr,textStatus){
                layer.msg('添加失败', {icon: 2});
            }
        });
        layer.close(insertIndex);
        layer.close(load);
    }

    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                if(data.id === '${id }'){
                    layer.alert('不能删除自己', {icon: 4});
                } else{
                    layer.confirm('真的删除行么', {icon: 3}, function(index){
                        var load = layer.load();
                        $.ajax({
                            url:'<%=request.getContextPath() %>/admin/delete_admin.do',
                            type:'GET',
                            async:false,    //是否异步
                            data:{
                                id:data.id
                            },
                            timeout:5000,    //超时时间
                            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                            success:function(result){
                                if(result.success){
                                    layer.msg('删除成功', {icon: 1});
                                    obj.del();
                                } else{
                                    layer.msg('删除失败', {icon: 2});
                                }
                            },
                            error:function(xhr,textStatus){
                                layer.msg('删除失败', {icon: 2});
                            }
                        });
                        layer.close(index);
                        layer.close(load);
                    });
                }
            } else if(obj.event === 'edit'){
                //layer.alert('编辑行：<br>'+ JSON.stringify(data));
                updateObj = obj;
                updateIndex = layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['840px', '420px'], //宽高
                    content: '\
          <div class="layui-form layui-form-pane">\
            <div class="layui-form-item">\
              <label class="layui-form-label">用户名</label>\
              <div class="layui-input-block">\
                <input type="text" id="id" name="id" autocomplete="off" placeholder="请输入用户名" class="layui-input" readonly unselectable="on">\
              </div>\
            </div>\
            <div class="layui-form-item">\
                <label class="layui-form-label">密码</label>\
                <div class="layui-input-block">\
                  <input type="text" id="password" name="password" autocomplete="off" placeholder="请输入密码" class="layui-input">\
                </div>\
              </div>\
            <button class="layui-btn" onclick="updateAdmin()">修改信息</button>\
          </div>\
        '
                });
                $("#id").val(data.id);
                $("#password").val(data.password);
            }
        });

        var $ = layui.$, active = {
            insertAdmin: function(){ //添加管理员
                insertIndex = layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['840px', '420px'], //宽高
                    content: '\
          <div class="layui-form layui-form-pane">\
            <div class="layui-form-item">\
              <label class="layui-form-label">用户名</label>\
              <div class="layui-input-block">\
                <input type="text" id="id" name="id" autocomplete="off" placeholder="请输入用户名" class="layui-input">\
              </div>\
            </div>\
            <div class="layui-form-item">\
                <label class="layui-form-label">密码</label>\
                <div class="layui-input-block">\
                  <input type="text" id="password" name="password" autocomplete="off" placeholder="请输入密码" class="layui-input">\
                </div>\
              </div>\
              <button class="layui-btn" onclick="insertAdmin()">添加信息</button>\
          </div>\
        '
                });
            },
            refreshAdmin: function(){
                table.reload('idTest', {
                    url: '<%=request.getContextPath() %>/admin/select_admin_list.do'
                    ,where: {} //设定异步数据接口的额外参数
                });
            },
            searchAdmin: function(){
                table.reload('idTest', {
                    url: '<%=request.getContextPath() %>/admin/select_admin_list.do'
                    ,where: {
                        id: $("#s_id").val()
                    } //设定异步数据接口的额外参数
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>

</body>
</html>
