layui.use(['jquery'],  function(){
    $ = layui.jquery;
    var path = $("#path").val();
    $.ajax({
        url:path+'/loginServlet?method=table',
        type:'post',
        data: {},
        success:function(data){
            if(data != null){
                var html = "";
                for(var i in data){
                    html += "<tr>";
                    html += "<td>" + data[i].userid + "</td>";
                    html += "<td>" + data[i].name + "</td>";
                    html += "<td>" + data[i].pwd + "</td>";
                    html += "</tr>";
                }
                $("#content").empty();
                $("#content").append(html);
            }
        },error:function (err) {
            console.log(err);
        }
    });
});