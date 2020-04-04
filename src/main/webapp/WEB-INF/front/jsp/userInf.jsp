<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-14
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
    <style>
        .layui-form-item{
            margin-left: 30%;
        }
        .layui-form-label{
            color: #ff1000;
        }
        .layui-input{
            width: 150px;
        }
        body{
            background-image: url(../../images/0004w.jpg);
        }
    </style>
</head>
<body>

<input type="hidden" id="path" value="<%=path%>">
<div class="layui-main-login">
    <form class="layui-form" action="" onsubmit="return false;">
    <c:if test="${not empty UserInf}">
        <div style="align-content: center">
            <div class="layui-form-item" style="margin-top: 5%">
                <label class="layui-form-label" >姓名</label>
                <div class="layui-input-inline">
                    <label type="text"  id="name" name="name"  class="layui-input" >${UserInf.name}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <label type="text"  id="sex" name="sex"  class="layui-input" >${UserInf.sex}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学历</label>
                <div class="layui-input-inline">
                    <label type="text"  id="education" name="education"  class="layui-input" >${UserInf.education}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职业</label>
                <div class="layui-input-inline">
                    <label type="text" id ="profession" name="profession" class="layui-input" >${UserInf.profession}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号</label>
                <div class="layui-input-inline">
                    <label type="text" id="phone" name="phone"  class="layui-input" >${UserInf.phone}</label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">Email</label>
                <div class="layui-input-inline">
                    <label type="text" id="Email" name="email"  class="layui-input" >${UserInf.email}</label>
                </div>
            </div>
        </div>
    </c:if>
    </form>
</div>
</body>
</html>
