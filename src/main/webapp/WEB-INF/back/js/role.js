layui.use(['table','jquery'], function(){
    var table = layui.table;
    $ = layui.jquery;
    var path =$("#path").val()


    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 450
        ,url:path+ '/admin/role' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'roleid', title: 'ID', width:70, sort: true, fixed: 'left'}//hide开启隐藏域
            ,{field: 'type', title: '角色名', width:100}
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
                    userid: $("#demoReload").val()
                }
            });
        }

    });
    //更新用户信息弹窗
    $('body').on('click', '.update', function() {
        var $td = $(this).parents('tr').children('td');
        var id = $td.eq(0).text();//获取点击按钮相对应的id


        layer.open({
            title:'更改用户权限',
            type: 2,
            area: ['300px', '400px'],
            content:path+"/admin/path/Authority",//弹出的页面
            success: function (layero, index) {
                var body = layer.getChildFrame("body", index);//弹出页面的body标签
                body.find("#mid").val(id);//先在原页面获取值后，在设置弹窗的值

            },

        });
    })




});




