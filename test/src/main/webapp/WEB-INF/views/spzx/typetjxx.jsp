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
		<tr><th>	详细商品库存信息		</th></tr>
		<tr><th>商品名称</th><th>库存数量</th><th>出售数量</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td nowrap="nowrap">${list.cosmetics_name}</td>
				<td>${list.cosmetics_count}</td>
				<td>${list.cosmetics_sale_count}</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
</body>
</html>
