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
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
</head>
<body>

<!-- 增加搜索条件 -->
    <div class="demoTable">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
<!-- -->

    <table id="demo" layui-filter="demotest"></table>

<script>
    layui.use('table', function(){
        var table = layui.table, $ = layui.jquery;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '../datagridServlet' //数据接口
            ,page: true //开启分页
            ,id: 'demotable'
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'userName', title: '用户名', width:80}
                ,{field:'sex', title: '性别', width: 200
                    ,templet: function(d){
                        return d.sex == 1 ? '男' : '女';
                    }
                }
            ]]
        });


        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            if(type == 'reload'){
                //执行重载
                table.reload('demotable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: $("#demoReload").val()
                    }
                });
            }
        });

    });

</script>
</body>
</html>
