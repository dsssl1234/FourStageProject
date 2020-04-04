layui.use('form', function(){
    var form = layui.form;
    var $ = layui.$;
    var path = $("#path").val();
    $("#account").blur(function (){
        $.ajax({
            url: path + "/loginServlet?method=cAccount",
            async: true,
            type: "post",
            data: "name=" + $("#account").val(),
            datatype: "text",
            success: function (msg) {
                if (msg == 1111) {
                    $("#err1").html("用户名可用");
                } else  {
                    $("#err1").html("用户名已经被注册");
                    // $("#account").val("")
                    return false;
                }
            },
            error: function () {
                alert("网络繁忙");
            }
        })
    })
    form.verify({
        account: [
            /^[\u4E00-\u9FA5A-Za-z0-9_]{2,18}$/
            , '正确用户名为2到18位中文、下划线、字母和数字组成'
        ],

    });


    //监听提交
    form.on('submit(adminForm)', function (data) {
        var path = $("#path").val();
        $.ajax({
            url: path + "/loginServlet?method=addConsult",
            async: true,
            type: "POST",
            data:  data.field,
            datatype: "text",
            // traditional: true,
            beforeSend:function () {
                if (null==$("#account").val()||""==$("#account").val()){
                    alert("账号不能为空");
                    return false;
                }
                if (null==$("#name").val()||""==$("#name").val()){
                    alert("姓名不能为空");
                    return false;
                }
                if (null==$("#password").val()||""==$("#password").val()){
                   layer.alert("密码不能为空");
                    return false;
                }

            },
            success: function (msg) {

                if (msg == 1111) {
                    alert("添加成功");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
                    window.location.reload();//刷新父级界面

                }else {
                    alert("添加失败");
                }
            },
            error: function () {
                alert("网络繁忙！")
            }
        });
        return false;
    });
});