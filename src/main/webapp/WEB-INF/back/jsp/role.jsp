<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-10
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户角色表</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/role.js"></script>

</head>
<body >
<input type="hidden" id="path" value="<%=path%>">
<table id="demo" lay-filter="test"></table>
<%--<script>--%>
<%--    //Demo--%>
<%--    layui.use('form', function(){--%>
<%--        var form = layui.form;--%>
<%--        //监听提交--%>
<%--        form.on('submit(formDemo)', function(data){--%>
<%--            layer.msg(JSON.stringify(data.field));--%>
<%--            return false;--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<script type="text/html" id="butdiv">
    <button class="layui-btn layui-btn-sm layui-btn-normal update">编辑角色权限</button>
</script>


</body>
</html>
