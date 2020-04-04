<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-14
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
</head>
<body>

<input type="hidden" id="path" value="<%=path%>">
<div class="layui-main-login">
    <form class="layui-form" action="" onsubmit="return false;">

<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">账号</label>--%>
<%--            <div class="layui-input-inline" style="width: 190px">--%>
<%--                <input  type="text" id="account" name="account" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>
<%--            <span id="err1" style="color: red"></span>--%>
<%--        </div>--%>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">密码</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="password" id="password"  name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>
<%--            <span id="err5" style="color: red"></span>--%>
<%--        </div>--%>
        <div> <input type="hidden" id="uid" name="uid"></div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text"  id="name" name="name" required lay-verify="name" placeholder="请在此输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学历</label>
            <div class="layui-input-block" style="width: 190px">
                <select id="education"  name="education" lay-verify="required">
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
                <input type="text" id ="profession" name="profession" required lay-verify="required" placeholder="请在此输入职业" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" required lay-verify="phone" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
            </div>
            <span id="err3" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Email</label>
            <div class="layui-input-inline">
                <input type="text" id="Email" name="Email" required lay-verify="Email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
            <span id="err4" style="color: red"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="state" value="启用" title="启用" checked>
                <input type="radio" name="state" value="禁用" title="禁用" >
            </div>
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
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //同时支持多条规则的验证
        form.verify({
            Email: [
                /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                , '请输入正确的邮箱地址'
            ],
            phone: [
                /^1(3|4|5|6|7|8|9)\d{9}$/
                , '请输入正确的手机号码'
            ],

        });
        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            var uid =$("#uid").val();
            console.log("uid=="+uid);
            var updateUserInf =JSON.stringify(data.field)
            var path = $("#path").val();
            $.ajax({
                url:path+'/admin/updateUserInf',
                type:'post',
                data: "updateUserInf="+updateUserInf+"&uid="+uid,
                success:function(data){
                    console.log("data=="+data)
                    if ("2222"==data){
                        layer.alert("更新失败",{icon:2});
                    }else if ("1111"==data) {
                        layer.alert("更新成功",{icon:6},function () {
                            window.parent.location.reload();
                        });
                    }else {
                        layer.alert("又来了",{icon:2});
                    }
                }, error: function () {
                    layer.alert("网络繁忙！")
                }
            });
            return false;
        });
    });
</script>
</html>
