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
		<tr><th>编号</th><th>建议人</th><th>建议内容</th><th>管理</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${page.content}" var="page">
			<tr>
				<td nowrap="nowrap">${page.id}</td>
				<td>${page.user.username}</td>
				<td>${page.advice}</td>
				<td nowrap="nowrap"><a href="${ctx}/gl/deleteadvice/${page.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<tags:pagination page="${page}" paginationSize="10"/>
</body>
</html>
