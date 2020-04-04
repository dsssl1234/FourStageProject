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
    <title>注册页面</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/addUser.js"></script>
    <style>
        .layui-main-login {
            margin-top: 2%;
            margin-left: 25%;
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
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline" style="width: 190px">
                <input  type="text" id="account" name="account" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
            <span id="err1" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码框</label>
            <div class="layui-input-inline">
                <input type="password" id="pwd"  name="pwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>

            <span id="err5" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">重复输入</label>
            <div class="layui-input-inline">
                <input type="password"  id="rpassword" name="rpassword" required lay-verify="required" placeholder="请在此输入密码" autocomplete="off" class="layui-input">
            </div>
            <span id="err2"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text"  id="name" name="name" required lay-verify="required" placeholder="请在此输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学历</label>
            <div class="layui-input-block" style="width: 190px">
                <select  name="education" lay-verify="required">
                    <option value=""></option>
                    <option value="博士">博士</option>
                    <option value="研究生">研究生</option>
                    <option value="本科">本科</option>
                    <option value="大专">大专</option>
                    <option value="大专以下">大专以下</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职业</label>
            <div class="layui-input-inline">
                <input type="text" name="profession" required lay-verify="required" placeholder="请在此输入职业" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" required lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
            </div>
            <span id="err3" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Email</label>
            <div class="layui-input-inline">
                <input type="text" id="Email" name="Email" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
            <span id="err4" style="color: red"></span>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
<%--                <button type="submit" class="layui-btn" lay-submit >立即提交</button>--%>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
