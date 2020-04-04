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
    <title>更改文档格式</title>
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
        <div> <input type="hidden" id="typeid" name="uid"></div>
        <div class="layui-form-item">
            <label class="layui-form-label">文档格式</label>
            <div class="layui-input-inline">
                <input type="text"  id="typename" name="typename" required lay-verify="name" placeholder="请在此输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">奖励分</label>
            <div class="layui-input-inline">
                <input type="text" id ="bounty" name="bounty" required lay-verify="required" placeholder="请在此输入职业" autocomplete="off" class="layui-input">
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
        //监听提交
        form.on('submit(formDemo)', function(data){
            var typeid =$("#typeid").val();
            var updateUserInf =JSON.stringify(data.field)
            var path = $("#path").val();
            $.ajax({
                url:path+'/admin/updateType',
                type:'post',
                data: "updateUserInf="+updateUserInf+"&typeid="+typeid,
                success:function(data){
                    if ("2222"==data){
                        layer.alert("更新失败",{icon:2});
                    }else if ("1111"==data) {
                        layer.alert("更新成功",{icon:6},function () {
                            window.parent.location.reload();
                        });
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
