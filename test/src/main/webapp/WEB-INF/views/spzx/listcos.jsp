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
		<tr><th><a href="${ctx}/gl/savecos">添加商品</a></th></tr>
		<tr><th>化妆品名称</th><th>化妆品库存数</th>
		<th>销售价</th><th>销售数量</th><th>市场价</th><th>类型</th>
		<th>管理</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${page.content}" var="cos">
			<tr>
				<td nowrap="nowrap"><a href="${ctx}/gl/getcos/${cos.cosmetics_id}">${cos.cosmetics_name}</a></td>
				<td>${cos.cosmetics_count}</td>
				<td>${cos.cosmetics_sale_price}</td>
				<td>${cos.cosmetics_sale_count}</td>
				<td>${cos.cosmetics_market_price}</td>
				<td>${cos.cosmeticstype.type_name}</td>
				<td nowrap="nowrap"><a href="${ctx}/gl/deletecos/${cos.cosmetics_id}">删除</a>
				| <a href="${ctx}/gl/updatecos/${cos.cosmetics_id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<tags:pagination page="${page}" paginationSize="10"/>
</body>
</html>
