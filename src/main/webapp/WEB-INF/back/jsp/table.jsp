<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-9
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
<%--    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>--%>
<%--    <script src="${pageContext.request.contextPath}/js/json2.js"></script>--%>
    <script src="<%=request.getContextPath()%>/back/js/table.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<table class="layui-table" lay-even lay-skin="line" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>ID</th>
        <th>昵称</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody id="content">
    <tr>
        <td>贤心</td>
        <td>2016-11-29</td>
        <td>人生就像是一场修行</td>
    </tr>
    <tr>
        <td>许闲心</td>
        <td>2016-11-28</td>
        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
    </tr>
    </tbody>
</table>
</body>
</html>
