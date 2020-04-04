<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-13
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文档格式</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/addType.js"></script>
    <style>
        .layui-main-login {
            margin-top: 8%;
            margin-left: 22%;
            padding-left: 10%;
            padding-top: 2%;
            width: 50%;
            background-color: #dadada;
        }
        .layui-layout-body{
            background-image: url(../../images/demo-1-bg.jpg);
            overflow:auto; /*这边设置是为了弹出的时候，如果框的大小小于内容，就出现滑动条*/

        }
    </style>
</head>
<body class="layui-layout-body">
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-main-login">
    <form class="layui-form" action=" " onsubmit="return false" >
        <div class="layui-form-item">
            <label class="layui-form-label">文档类型</label>
            <div class="layui-input-inline" style="width: 190px">
                <input  type="text" id="typename" name="typename" required  lay-verify="required" placeholder="请输入文档类型" autocomplete="off" class="layui-input">
            </div>
            <span id="err1" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">奖励分</label>
            <div class="layui-input-inline">
                <input type="text" id="bounty" name="bounty" required lay-verify="required" placeholder="请输入奖励分" autocomplete="off" class="layui-input">
            </div>
            <span id="err3" style="color: red"></span>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
