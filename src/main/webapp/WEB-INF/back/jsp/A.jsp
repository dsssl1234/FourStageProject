<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-10
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面跳转</title>
</head>
<body>
<ul>
    <a href="<%=request.getContextPath()%>/user/path/login" ><li>前台登录</li></a>
    <a href="${pageContext.request.contextPath}/admin/path/login" ><li>后台登录</li></a>
    <a href="<%=request.getContextPath()%>/admin/path/table2"><li>表格2</li></a>
    <a href="<%=request.getContextPath()%>/user/path/register"><li>注册</li></a>
    <a href="<%=request.getContextPath()%>/admin/path/dialog"><li>弹出</li></a>
    <a href="<%=request.getContextPath()%>/user/path/upload"><li>上传</li></a>
</ul>
</body>
</html>
