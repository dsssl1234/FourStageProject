<%--
  Created by IntelliJ IDEA.
  User: HJY
  Date: 2020-3-10
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文档审核</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %> media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/jquery-3.4.1.js"></script>
        <script src="<%=request.getContextPath()%>/back/js/json2.js"></script>
    <script src="<%=request.getContextPath()%>/back/js/documentReview.js"></script>

</head>
<body >
<input type="hidden" id="path" value="<%=path%>">

<!-- 增加搜索条件 -->
<div class="demoTable">
    <div style="float: left;margin-left: 20%;">
        <label class="layui-form-label" >文档标题</label>
        <div class="layui-inline">
            <input class="layui-input"  id="title" autocomplete="off">
        </div>
    </div>
   <div style="float: left">
       <label class="layui-form-label" >上传人</label>
       <div class="layui-inline">
           <input class="layui-input"  id="who" autocomplete="off">
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
   <div style="clear: left;margin-left: 30%;padding-top: 1%;">
       <label class="layui-form-label" >上传时间</label>
       <div class="layui-inline">
           <input class="layui-input" type="date" name="time1" id="time1" autocomplete="off">
       </div>
       至:
       <div class="layui-inline">
           <input class="layui-input" type="date" name="time2"  id="time2"autocomplete="off">
       </div>
       <button class="layui-btn" id="btn1" data-type="reload">搜索</button>
       <a href="<%=request.getContextPath()%>/admin/downDocumentInf" >下载</a>
   </div>

</div>

<table id="demo" lay-filter="test"></table>



<script type="text/html" id="butdiv">
    {{#  if(d.dstate == "待审核"){ }}
    <button class="layui-btn layui-btn-sm " lay-event="down" >下载</button>
    <button class="layui-btn layui-btn-sm layui-btn-normal ok">审核通过</button>
    <button class="layui-btn layui-btn-sm layui-btn-danger ok">审核不通过</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-sm " lay-event="down">下载</button>
    {{#  } }}
</script>
</body>
</html>
