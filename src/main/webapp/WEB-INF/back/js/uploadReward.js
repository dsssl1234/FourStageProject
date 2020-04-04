layui.use(['table','jquery'], function(){
    var table = layui.table;
    $ = layui.jquery;
    var path =$("#path").val()




    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 450
        ,url:path+ '/admin/uploadReward' //数据接口
        // ,where: {token: 'sasasas', id: 123} //如果无需传递额外参数，可不加该参数
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'typeid', title: 'ID', width:70, sort: true, fixed: 'left'}//hide开启隐藏域
            ,{field: 'typename', title: '文件格式', width:100}
            ,{field: 'bounty', title: '奖励分数', width:100}
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
                    typename: $("#demoReload").val(),
                }

            });
        }

    });
    //更新用户信息弹窗
    $('body').on('click', '.update', function() {
        var $td = $(this).parents('tr').children('td');
        var id = $td.eq(0).text();//获取点击按钮相对应的id
        var typename = $td.eq(1).text();//获取点击按钮相对应的类型
        var bounty = $td.eq(2).text();//获取点击按钮相对应的奖励分数

        layer.open({
            title:'更改文档格式',
            type: 2,
            area: ['500px', '400px'],
            content:path+"/admin/path/updateType",//弹出的页面
            success: function (layero, index) {
                var body = layer.getChildFrame("body", index);//弹出页面的body标签
                body.find("#typeid").val(id);//先在原页面获取值后，在设置弹窗的值
                body.find("#typename").val(typename);//设置弹窗的值
                body.find("#bounty").val(bounty);//设置职业的值

            },

        });
    })
    //删除
    $('body').on('click', '.delete', function() {
        var $td = $(this).parents('tr').children('td');
        var typeid = $td.eq(0).text();//获取点击按钮相对应的id
        layer.confirm('确定删除?',{icon:3,title:'提示'},function (index) {
            $.ajax({
                async:true,
                method : "POST",
                url :path+'/admin/deleteType',
                data: "typeid="+typeid,
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


    //添加用户弹窗
    $('.layui-btn').on('click', function(){
        var othis = $(this), //othis当前button对象
            method = othis.data('method');//data-method="dialog"中的值
        if(method == "dialog"){
            layer.open({
                title:'添加用户',
                type: 2,
                area: ['1000px', '400px'],
                content: path+'/admin/path/addType',
            });
        }
    });

});




