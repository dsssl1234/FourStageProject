<%--
  Created by IntelliJ IDEA.
  User: Mr.Fan
  Date: 2020-3-10
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件查询</title>
    <%String path = request.getContextPath(); %>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src=<%=path + "/layui/layui.js"%>></script>
    <script src="<%=request.getContextPath()%>/front/js/fileLoad.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" onsubmit="return false">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2 style="margin-left: 43%">文件查询</h2>
    </div>
    <div class="layui-inline" style="width:100%;">
        <hr>
    </div>

    <div class="layui-fluid" id="searchTable">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <div style="padding-bottom: 10px;">
                <div class="layui-upload">
                    搜索条件：
                    <div class="layui-inline">
                        <input class="layui-input"  id="demoReload" autocomplete="off" placeholder="请输入文档名称" style="width: 200px">
                    </div>
                    <button type="button" class="layui-btn layui-btn-normal" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索文档</button>
                    <button type="button" class="layui-btn layui-btn-warm" id="chooseFile"><i class="layui-icon">&#xe67c;</i>上传文件</button>
                    <button type="button" class="layui-btn" id="save"><i class="layui-icon">&#x1005;</i>保存文件</button>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-anim layui-anim-scale">
        <table id="dataTable" lay-filter="test"></table>
    </div>

    <script type="text/html" id="butdiv">
        <button class="layui-btn layui-btn-sm layui-btn-normal " lay-event="down"><i class="layui-icon">&#xe601;</i>下载文档</button>
    </script>

</form>
</body>
</html>
