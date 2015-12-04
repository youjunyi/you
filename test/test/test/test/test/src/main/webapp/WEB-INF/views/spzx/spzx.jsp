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
		<tr><th><a href="${ctx}/gl/savezx">添加资讯</a></th></tr>
		<tr><th>咨讯主题</th><th>咨讯内容</th><th>咨讯类型</th><th>管理</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${zixun.content}" var="zixun">
			<tr>
				<td nowrap="nowrap">${zixun.title}</td>
				<td>${zixun.content}</td>
				<td nowrap="nowrap">
			<c:if test="${zixun.zixun_type==1}"> 国内资讯</c:if>
				<c:if test="${zixun.zixun_type==2}">国际资讯</c:if>
					<c:if test="${zixun.zixun_type==3}">化妆品动态</c:if>
				</td>
				
				<td nowrap="nowrap"><a href="${ctx}/gl/deletezx/${zixun.zixun_type_id}">删除</a>
				| <a href="${ctx}/gl/updatezx/${zixun.zixun_type_id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<tags:pagination page="${zixun}" paginationSize="5"/>
</body>
</html>
