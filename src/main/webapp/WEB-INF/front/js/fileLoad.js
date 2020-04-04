layui.use(['upload', 'jquery', 'layer','table','laydate'], function () { //导入模块
    var upload = layui.upload,
        $ = layui.jquery;
    var layer = layui.layer;
    var laydate = layui.laydate;
    var table = layui.table;
    var path = $("#path").val();

    //第一个实例
    table.render({
        elem: '#dataTable'
        , height: 280
        , url: path + '/user/DocumentTableInf' //数据接口
        , page: true //开启分页
        , id: 'searchTable'
        , limit: 5
        , limits: [5, 10, 15, 20]
        , cols: [[ //表头
            {field: 'did', title: '文档ID', width: 120, sort: true, fixed: 'left', align: 'center'}
            , {field: 'title', title: '文档名称', width: 120, align: 'center'}
            , {field: 'name', title: '上传人员', width: 120, align: 'center'}
            , {field: 'uptime', title: '上传时间', width: 120, sort: true, align: 'center'}
            , {field: 'downscore', title: '下载积分', width: 120, sort: true, align: 'center'}
            , {field: 'typename', title: '文档类型', width: 160, sort: true,align: 'center'}
            , {field: 'downcount', title: '下载次数', width: 180, sort: true, align: 'center'}
            , {field: '', title: '操作', toolbar: "#butdiv", width: 200, align: 'center'}
        ]]
    });

    $('#searchTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        if (type == 'reload') {
            //执行重载
            table.reload('searchTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    key: $("#demoReload").val(),
                }
            });
        }
    });


    //下载
    table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        // var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
        var path1 = $("#path").val();
        if (layEvent === 'down') {
            $.ajax({
                url:path1+'/user/judgeScore',
                type:'post',
                data: data,
                success:function(msg){
                    if ("success"==msg){
                        window.location.href = path1 + '/user/downDocumentInf?did=' + data.did;
                    }else {
                        layer.alert("会员积分不够",{icon:2});
                    }
                },error:function (err) {
                    layer.alert("网络繁忙",{icon:2});
                }
            });

        }
    });
});