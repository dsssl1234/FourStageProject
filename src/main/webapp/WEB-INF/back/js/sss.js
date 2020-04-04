layui.use('element', function(){
    var element = layui.element;

});
function GoodsManager(node) {
    var  divNode = document.getElementById("iframe_div");
         divNode.src = node.title;

}

function deleteAdmin() {
    var path =$("path").val();
    console.log(path)
    location.href=path+"/admin/deleteAdmin"
    alert(1)
}