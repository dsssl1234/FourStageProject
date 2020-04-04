<%--
  Created by IntelliJ IDEA.
  User: Mr.Fan
  Date: 2020-3-10
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传记录</title>
    <%String path = request.getContextPath(); %>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src=<%=path + "/layui/layui.js"%>></script>
    <script src="<%=request.getContextPath()%>/front/js/uploadRecord.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" onsubmit="return false;">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2 style="margin-left: 43%">我的上传记录</h2>
    </div>
    <div class="layui-inline" style="width:100%;">
        <hr>
    </div>

    <div class="layui-fluid" id="searchTable">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <div style="padding-bottom: 10px;">
                <div class="layui-upload">
                    <div style="float: left;margin-left: 23%">
                        <label class="layui-form-label">状态</label>
                        <div class="layui-input-block" style="width: 190px;">
                            <select  name="state" id="state" lay-verify="required">
                                <option value=""></option>
                                <option value="已通过">已通过</option>
                                <option value="未通过">未通过</option>
                                <option value="待审核">待审核</option>
                            </select>
                        </div>
                    </div>

                    <div style="float: left">
                        <label class="layui-form-label" >文档类型</label>
                        <div class="layui-input-block" style="width: 190px">
                            <select  name="type" id="type" lay-verify="required">
                                <option value=""></option>
                                <c:if test="${not empty documentTypes}">
                                    <c:forEach items="${documentTypes}" var="i" step="1">
                                        <option value="${i.typeid}" <c:if test="${type==i.typeid}">selected="selected"</c:if>>${i.typename}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div style="clear: left;padding-top: 10px;margin-left: 25%">
                        <label class="layui-form-label" >上传时间</label>
                        <div class="layui-inline">
                            <input class="layui-input" type="date" name="time1" id="time1" autocomplete="off">
                        </div>
                        至:
                        <div class="layui-inline" style="clear: left">
                            <input class="layui-input" type="date" name="time2"  id="time2"autocomplete="off">
                        </div>
                        <button type="button"  class="layui-btn layui-btn-normal" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
                    </div>
                    </div>
            </div>
        </div>
    </div>

    <div class="layui-anim layui-anim-scale">
        <table id="dataTable" lay-filter="test"></table>
    </div>

    <script type="text/html" id="butdiv">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="delete" ><i class="layui-icon">&#xe640;</i>删除</button>
    </script>

</form>

</body>
</html>
