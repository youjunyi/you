<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>分成管理</title>
</head>
<body>
<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>名称：</label> <input type="text" name="search_LIKE_name" class="input-medium" value="${param.search_LIKE_name}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><th>分成比例</th><th>类型</th><th>备注</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${fengcheng.content}" var="fengcheng">
			<tr>
				<td><a href="${ctx}/fengcheng/update/${fengcheng.id}">${fengcheng.name}</a></td>
				<td>${fengcheng.fcbl}</td>
				<td>${fengcheng.bz }</td>
				<td><c:if test="${fengcheng.lx == 1}">普通</c:if><c:if test="${fengcheng.lx==2}">特殊</c:if></td>
				<td><a href="${ctx}/fengcheng/delete/${fengcheng.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${fengcheng}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/fengcheng/save">创建分成</a></div>
</body>
</html>