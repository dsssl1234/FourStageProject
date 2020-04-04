<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-10
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传奖励</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/uploadReward.js"></script>

</head>
<body >
<input type="hidden" id="path" value="<%=path%>">

<!-- 增加搜索条件 -->
<div class="demoTable">
    搜索格式类型：
    <div class="layui-inline">
        <input class="layui-input"  id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" id="btn1" data-type="reload">搜索</button>
    <button data-method="dialog" class="layui-btn">新增类型</button>
</div>

<table id="demo" lay-filter="test"></table>


<script type="text/html" id="butdiv">
    <button class="layui-btn layui-btn-sm layui-btn-normal update">编辑</button>
    <button class="layui-btn layui-btn-sm layui-btn-danger delete">删除</button>
</script>
</body>
</html>
