layui.use(['table','jquery'], function(){
    var table = layui.table;
    $ = layui.jquery;
    var path =$("#path").val()




    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 450
        ,url:path+ '/admin/documentReview' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'did', title: 'ID', width:70, sort: true, fixed: 'left'}//hide开启隐藏域
            ,{field: 'title', title: '文档标题', width:180}
            ,{field: 'userid', title: '上传人id', width:100,hide:true}
            ,{field: 'name', title: '上传人', width:100}
            ,{field: 'uptime', title: '上传时间', width:180, sort: true}
            ,{field: 'downscore', title: '下载积分', width:90, }
            ,{field: 'typename', title: '文档类型', width:150}
            ,{field: '', title: '操作',toolbar:'#butdiv', width:280, }
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
                    title: $("#title").val(),
                    who: $("#who").val(),
                    type:$("#type option:selected").text(),//拿到下拉框选中的值
                    time1: $("#time1").val(),
                    time2: $("#time2").val()
                }

            });
        }

    });

    //修改状态
    $('body').on('click', '.ok', function() {
        var type = $(this).text();
        var $td = $(this).parents('tr').children('td');
        var did = $td.eq(0).text();//获取点击按钮相对应的id
        var userid = $td.eq(2).text();
        var typename = $td.eq(6).text();//获取文档类型
        layer.confirm('确定修改?',{icon:3,title:'提示'},function (index) {
            $.ajax({
                async:true,
                method : "POST",
                url :path+'/admin/changeDocumentState',
                data: "did="+did +"&butName="+type+"&typename="+typename+"&userid="+userid,
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

    //下载
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        // var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
        var path1 = $("#path").val();
        if(layEvent === 'down'){ //查看
            console.log(data.did)
            // var elink = document.createElement("a");
            // elink.setAttribute("href",path1+'/admin/downDocumentInf?did='+data.did)
            window.location.href=path1+'/admin/downDocumentInf?did='+data.did;
            // $.ajax({
            //     async:true,
            //     method : "POST",
            //     url :path1+'/admin/downDocumentInf',
            //     data: data,
            //     dataType : "text",
                // success:function(data){
                //     var msg = eval('(' + data + ')'); //转换字符串为json对象
                //     console.log("msg=="+msg)
                //     console.log("msg1=="+msg.url)
                //     var elink = document.createElement("a");
                //     elink.download = msg.title;
                //     elink.style.display = "none";
                //     var blob = new Blob([msg.url]);
                //     if ("success"==data){
                //         layer.alert("删除成功",{icon:6},function () {
                //             window.parent.location.reload();
                //         });
                //     }else {
                //         layer.alert("删除失败",{icon:2});
                //     }
                // }
            // })
        }
    });



});




