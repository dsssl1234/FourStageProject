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
    <title>注册奖励</title>
    <%String path = request.getContextPath(); %>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src=<%=path + "/layui/layui.js"%>></script>
    <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/registIncentives.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2 style="margin-left: 43%">注册奖励设置</h2>
    </div>
    <div class="layui-inline" style="width:100%;">
        <hr>
    </div>

    <div class="layui-fluid" id="searchTable" style="margin-left: 25%">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <div style="padding-bottom: 10px;">
                <div class="layui-upload">
                    注册积分奖励：
                    <div class="layui-inline">
                        <input class="layui-input"  id="score" autocomplete="off" placeholder="不写默认为0" style="width: 200px">
                    </div>
                    <button type="button" class="layui-btn" id="save"><i class="layui-icon">&#x1005;</i>保存设置</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
