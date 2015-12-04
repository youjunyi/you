<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	
		<thead>
		<tr><th><a href="${ctx}/gl/savetyep">添加类型</a></th></tr>
		<tr><th>类别id</th><th>类别名称</th><th>管理</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${costype.content}" var="costype">
			<tr>
				<td nowrap="nowrap">${costype.type_id}</td>
				<td>${costype.type_name}</td>
				<td nowrap="nowrap"><a href="${ctx}/gl/deletetype/${costype.type_id}">删除</a>
				| <a href="${ctx}/gl/updatetype/${costype.type_id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<tags:pagination page="${costype}" paginationSize="10"/>
</body>
</html>
