layui.use('form', function(){
    var form = layui.form;
    var $ = layui.$;
    //监听提交
    form.on('submit(formDemo)', function(data){
        var path = $("#path").val();
        var addTypeInf =JSON.stringify(data.field)
        $.ajax({
            url: path + "/admin/addType",
            async: true,
            type: "POST",
            data:"addTypeInf="+addTypeInf,
            datatype: "text",
            success: function (msg) {
                if (msg == "success") {
                    layer.alert("新增成功",{icon:6},function () {
                        window.parent.location.reload();
                    });

                }else {
                    layer.alert("新增失败");
                }
            },
            error: function () {
                layer.alert("网络繁忙！")
            }
        });
        return false;
    });
});