<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-2-27
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>权限管理</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/authority.js"></script>

</head>
<body>
    <input type="hidden" id="path" value="<%=path%>">
    <div> <input type="hidden" id="mid" name="mid"></div>
<%--    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 25px;">--%>
<%--        <legend>显示搜索框</legend>--%>
<%--    </fieldset>--%>
<%--    <button type="button" class="layui-btn layui-btn-normal" id="doctor" style="margin-left: 38%;margin-bottom: 1%">查询</button>--%>
    <div class="layui-btn-container">
        <button type="button" class="layui-btn layui-btn-normal" id="admin" style="margin-bottom: 1%;float: left">查询</button>
        <button type="button" class="layui-btn layui-btn-normal" id="Sure" style="display: none; float: left">确定修改</button>
    </div>
    <div id="test13" class="demo-tree-more" style="clear: left"></div>


</body>
</html>
