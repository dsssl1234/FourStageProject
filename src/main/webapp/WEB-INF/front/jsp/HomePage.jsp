<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-9
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <%--    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/json2.js"></script>--%>
    <script src="<%=request.getContextPath()%>/front/js/HomePage.js"></script>
    <style>
        .layui-layout-admin .layui-body {
            /*去掉底部固定区域44px*/
            bottom: 0px;
        }
    </style>

</head>
<body class="layui-layout-body">
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <% String name = (String)session.getAttribute("name"); %>
                    <% String roleType = (String)session.getAttribute("roleType"); %>
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    欢迎<%=name %><%=roleType%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/user/deleteUser">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black" id="test13" >
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <c:if test="${not empty menuMap}">
                    <c:forEach items="${menuMap}" step="1" var="i">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">${i.key}</a>
                        <dl class="layui-nav-child">
                        <c:forEach items="${i.value}" step="1" var="j">
                            <dd><a href="javascript:void(0)"
                            title="<%=request.getContextPath()%>/${j.murl}"
                            onclick="GoodsManager(this)">${j.menuname}</a></dd>
                        </c:forEach>
                        </dl>
                    </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframe_div" style="width: 100%;height: 100%;" name="ifram_div_ifram" src=" " height="100%" width="100%" ></iframe>
    </div>
</div>

</body>
</html>
