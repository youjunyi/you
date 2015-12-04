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
		<tr><th>订单编号</th><th>订单时间</th><th>订单邮费</th><th>订单金额</th><th>订单用户</th><th>订单状态</th><th>用户地址</th><th>用户电话</th><th>管理</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td nowrap="nowrap">${list.id}</td>
				<td>${list.time}</td>
				<td>${list.post_money}</td>
				<td>${list.total_money}</td>
				<td>${list.username}</td>
				<td>${list.state}</td>
				<td>${list.dizi}</td>
				<td>${list.dianha}</td>
				<td nowrap="nowrap">
				<a href="${ctx}/gl/updatemyorder/${list.id}">发货</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
</body>
</html>
