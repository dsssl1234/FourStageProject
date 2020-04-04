<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-12-24
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/from.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action=" " >
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" id="account" name="account" required  lay-verify="account" placeholder="请输入标题" autocomplete="on" class="layui-input">
        </div>
       <div><span type="text"  id="err1" style="color: red" ></span></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" id="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">辅助文字</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名框</label>
        <div class="layui-input-inline">
            <input type="text"  id="name" name="name" required lay-verify="name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男">
            <input type="radio" name="sex" value="女" title="女" checked>
        </div>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">复选框</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="like[write]" title="写作">--%>
<%--            <input type="checkbox" name="like[read]" title="阅读" checked>--%>
<%--            <input type="checkbox" name="like[dai]" title="发呆">--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="adminForm" style="text-align: center">立即提交</button>
        </div>
    </div>

</form>
<%--<script>--%>
<%--    //Demo--%>
<%--    layui.use('form', function(){--%>
<%--        var form = layui.form;--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
