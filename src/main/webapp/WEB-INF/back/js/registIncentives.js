

layui.use(['table','jquery'], function() {

    $("#save").click(function () {
        var path = $("#path").val();
        var score = $("#score").val();
        $.ajax({
            async:true,
            url:path+'/admin/registIncentives',
            type:'post',
            data: "score="+score,
            dataType : "text",
            success:function(data){
                if ("error"==data){
                    layer.alert("设置失败",{icon:2});
                }else {
                    layer.alert("设置成功",{icon:6},function () {
                        window.parent.location.reload();
                    });
                }
            },error:function (err) {
                layer.alert("网络繁忙",function () {
                    window.location.reload();
                });
            }
        });
    })
})
