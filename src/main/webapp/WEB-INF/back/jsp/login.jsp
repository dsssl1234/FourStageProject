<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-15
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/login.js"></script>
    <style>
        .layui-main-login {
            /*margin-top: 15%;*/
            /*margin-left: 35%;*/
            /*padding: 2% 0;*/
            /*width: 30%;*/
            /*background-color: #dadada;*/
            padding: 2%;
            width:30%;
            /*height:280px;*/
            background-color: #dadada;
            float: right;
            margin:150px 200px 0 0 ;
        }
        body{
            background-image: url(../../images/demo-1-bg.jpg);
        }
        #p21{
        }
    </style>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-main-login">
    <form class="layui-form" action=""  onsubmit="false" >
        <div class="layui-form-item">
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block" style="width: 190px">
                <input type="text" name="account" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码框</label>
            <div class="layui-input-inline">
                <input type="password" name="pwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
<%--            <div class="layui-form-mid layui-word-aux">辅助文字</div>--%>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码</label>
            <div class="layui-input-block" style="width: 190px">
                <input type="text" name="rePass" required  lay-verify="required" placeholder="不区分大小写" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <img id="passPhoto"  style="padding-left: 110px;" src="<%=request.getContextPath()%>/admin/CheckCodeServlet" onclick="refreshCode()">
            <a  style=" font-size:12px;color: red" onclick="refreshCode()" >看不清?点图片刷新</a>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <%--走ajax提交--%>
        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <%--走表单提交--%>
<%--                <button type="submit" class="layui-btn" lay-submit >立即提交</button>--%>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
<%--        <div id="p21">--%>
<%--            <a id="p5" href="<%=request.getContextPath()%>/web/front/jsp/register.jsp" style="color: red;padding-left: 60%;">立即注册新账户</a>--%>
<%--        </div>--%>
    </form>
</div>
</body>
</html>
