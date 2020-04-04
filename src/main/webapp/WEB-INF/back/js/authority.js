
$(function () {
    $("#admin").click(function () {
        document.getElementById("Sure").style.display='block';
         var mid = $("#mid").val();
        console.log("mid="+mid)
        layui.use(['tree', 'util'], function(){
            var path = $("#path").val();
            var ids = [];
            var tree = layui.tree
                ,layer = layui.layer
                ,util = layui.util
            $.ajax({
                url:path+"/admin/adminAuthority",
                async:true,
                type:"post",
                data:"mid="+mid,
                datatype : "text",
                success:function (msg) {

                    //这边穿回来的是个Map，所有要通过键值拿到对应的value值
                    for (var i =0;i<msg["mid"].length;i++){
                        ids.push(msg["mid"][i].id)
                    }
                    console.log("sss="+ids.toString())
                    tree.render({
                        elem: '#test13'
                        ,data: msg["menu"]
                        ,showCheckbox: true //是否显示复选框
                        ,showLine: false  //是否开启连接线
                        ,id:"te1"
                    });
                    tree.setChecked('te1', ids);//设置一开始就选中的值
                }
            })
            $("#Sure").click(function () {

                var checkData = tree.getChecked('te1');//获取选中的所有对象的集合
                var fatherNodeId = [];
                var objectData = [];
                var sonNodeId = [];
                var checkedId = [];
                for(var i = 0;i<checkData.length;i++){
                    fatherNodeId.push(checkData[i].id);
                    objectData.push(checkData[i].children);
                }
                for(var j = 0;j<objectData.length;j++){
                    for(var k in objectData[j]){
                        sonNodeId.push(objectData[j][k].id);
                    }
                }
                checkedId.push(fatherNodeId);
                checkedId.push(sonNodeId);
                layer.confirm('您确定要修改吗?', {icon: 3, title:'提示'}, function(index){
                    var path = $("#path").val();
                    if(0 != checkedId.length){
                        var msg = {'fatherNodeId':fatherNodeId,'sonNodeId':sonNodeId};
                        msg = JSON.stringify(msg);
                        $.ajax({
                            url: path + '/admin/sureAuthority',
                            async:true,
                            type: 'post',
                            data: 'MenuTable='+msg+"&mid="+mid,
                            datatype:'text',
                            success:function (data) {
                                if (data == "success"){
                                    layer.alert("菜单配置成功，请重新登录！",{icon:6},function (index) {
                                        layer.close(index);
                                        window.parent.location.reload();
                                        parent.layer.close(index);
                                    });

                                }else {
                                    layer.alert("菜单配置失败！",{icon:2},function (index) {
                                        layer.close(index);
                                    });
                                }
                            },error:function (data) {
                                layer.alert("网络异常！",{icon:2},function (index) {
                                    layer.close(index);
                                });
                            }
                        })
                    }else {
                        layer.alert("不能删除所有菜单！",{icon:2},function (index) {
                            layer.close(index);
                        });
                    }
                });



                // var re = JSON.stringify(checkData)//把获取到对象转成字符串
                // var msg = {'fatherNodeId':fatherNodeId,'sonNodeId':sonNodeId,'roleid':roleid};
                // msg = JSON.stringify(msg);
                // console.log("checkData="+re)
                // $.ajax({
                //     url:path+"/admin/sureAuthority",
                //     async:true,
                //     type:"post",
                //     data:"checkData="+re+"&mid="+mid,
                //     datatype : "text",
                //     traditional:true,
                //     success:function (msg2) {
                //         console.log("msg2="+msg2)
                //         if ("success"==msg2){
                //             layer.alert("变更成功")
                //         }else{
                //             layer.alert("变更失败")
                //         }
                //     }
                // })
            })
        });
    })
})



