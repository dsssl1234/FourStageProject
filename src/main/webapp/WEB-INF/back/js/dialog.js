layui.use(['layer','form'], function(){
    var layer = layui.layer, $ = layui.jquery;
    var path =$("#path").val()
    $('.layui-btn').on('click', function(){

        var othis = $(this), //othis当前button对象
            method = othis.data('method');//data-method="dialog"中的值

        if(method == "dialog"){
            layer.open({
                type: 2,
                area: ['500px', '300px'],
                // btn: ['添加', '取消'],
                content: path+'/admin/path/register'
                // btn1: function(index, layero){
                    //layer.getChildFrame("form", index)获取iframe的表单
                    //serializeArray jquery方法，将表单对象序列化为数组
                //     var formData = serializeObject($, layer.getChildFrame("form", index).serializeArray());
                //     $.ajax({
                //         url:'../formServlet',
                //         type:'post',
                //         data: formData,
                //         success:function(data){
                //             layer.close(index);
                //         },error:function (err) {
                //             console.log(err);
                //         }
                //     });
                // },
                //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                // ,success: function(layero, index){
                //     console.log(layero, index);
                // }
            });
        }
    });

});

//将表单转为js对象数据
function serializeObject($, array){
    var obj=new Object();
    $.each(array, function(index,param){
        if(!(param.name in obj)){
            obj[param.name]=param.value;
        }
    });
    return obj;
};