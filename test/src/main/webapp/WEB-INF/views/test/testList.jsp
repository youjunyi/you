<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>任务管理</title>
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
		<thead><tr><th>名称</th><th>折扣率</th><th>备注</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${zhekou.content}" var="zhekou">
			<tr>
				<td><a href="${ctx}/zhekou/update/${zhekou.id}">${zhekou.name}</a></td>
				<td>${zhekou.zkl}</td>
				<td>${zhekou.bz }</td>
				<td><a href="${ctx}/zhekou/delete/${zhekou.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${zhekou}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/zhekou/create">创建任务</a></div>
</body>
</html>