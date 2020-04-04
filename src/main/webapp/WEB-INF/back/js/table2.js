layui.use(['table','jquery'], function(){
    var table = layui.table;
    $ = layui.jquery;
    var path =$("#path").val()




    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 450
        ,url:path+ '/admin/UserTableInf' //数据接口
        // ,where: {token: 'sasasas', id: 123} //如果无需传递额外参数，可不加该参数
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'userid', title: 'ID', width:70, sort: true, fixed: 'left'}//hide开启隐藏域
            ,{field: 'account', title: '账号', width:100}
            ,{field: 'name', title: '用户名', width:100}
            ,{field: 'sex', title: '性别', width:50, sort: true}
            ,{field: 'education', title: '学历', width:90, }
            ,{field: 'profession', title: '职业', width:80}
            ,{field: 'phone', title: '手机号码', width:120}
            ,{field: 'Email', title: '邮箱', width:150}
            ,{field: 'state', title: '状态', width:50}
            ,{field: 'rtime', title: '注册时间', width:120}
            ,{field: '', title: '操作',toolbar:'#butdiv', width:200, }
        ]]
        ,id: 'testReload'


    });

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        if(type == 'reload'){
            //执行重载
            table.reload('testReload', {//拿到全部数据的id
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    userid: $("#demoReload").val(),
                    time1: $("#time1").val(),
                    time2: $("#time2").val()
                }

            });
        }

    });
    //更新用户信息弹窗
    $('body').on('click', '.update', function() {
        var $td = $(this).parents('tr').children('td');
        var id = $td.eq(0).text();//获取点击按钮相对应的id
        var name = $td.eq(2).text();//获取点击按钮相对应的id
        var profession = $td.eq(5).text();//获取点击按钮相对应的id
        var phone = $td.eq(6).text();//获取点击按钮相对应的id
        var Email = $td.eq(7).text();//获取点击按钮相对应的id

        layer.open({
            title:'更改用户信息',
            type: 2,
            area: ['500px', '400px'],
            content:path+"/admin/path/userInfUpdate",//弹出的页面
            // content:$("#index").html,//index为写在jsp中的页面id,要把type注销才能实现
            success: function (layero, index) {
                var body = layer.getChildFrame("body", index);//弹出页面的body标签
                body.find("#uid").val(id);//先在原页面获取值后，在设置弹窗的值
                body.find("#name").val(name);//设置弹窗的值
                body.find("#profession").val(profession);//设置职业的值
                body.find("#phone").val(phone);
                body.find("#Email").val(Email);
            },

        });
    })
    //删除
    $('body').on('click', '.delete', function() {
        var $td = $(this).parents('tr').children('td');
        var uid = $td.eq(0).text();//获取点击按钮相对应的id
        layer.confirm('确定删除?',{icon:3,title:'提示'},function (index) {
            $.ajax({
                async:true,
                method : "POST",
                url :path+'/admin/deleteUserInf',
                data: "uid="+uid,
                dataType : "text",
                success:function(data){
                    if ("error"==data){
                        layer.alert("删除失败",{icon:2});
                    }else {
                        layer.alert("删除成功",{icon:6},function () {
                            window.parent.location.reload();
                        });
                    }
                }
            })
            layer.close(index);
        })
    })

    //修改状态
    $('body').on('click', '.state', function() {
        var type = $(this).text();
        var $td = $(this).parents('tr').children('td');
        var uid = $td.eq(0).text();//获取点击按钮相对应的id
        layer.confirm('确定修改?',{icon:3,title:'提示'},function (index) {
            $.ajax({
                async:true,
                method : "POST",
                url :path+'/admin/changeUserState',
                data: "uid="+uid +"&butName="+type,
                dataType : "text",
                success:function(data){
                    if ("error"==data){
                        layer.alert("修改失败",{icon:2});
                    }else {
                        layer.alert("修改成功",{icon:6},function () {
                            window.location.reload();
                        });
                    }
                }
            })
            layer.close(index);
        })

    })

    //添加用户弹窗
    $('.layui-btn').on('click', function(){
        var othis = $(this), //othis当前button对象
            method = othis.data('method');//data-method="dialog"中的值
        if(method == "dialog"){
            layer.open({
                title:'添加用户',
                type: 2,
                area: ['1000px', '400px'],
                content: path+'/admin/path/addUser',
            });
        }
    });

});




