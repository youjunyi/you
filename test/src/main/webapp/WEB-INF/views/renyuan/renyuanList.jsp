<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>人员管理</title>
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
		<thead><tr><th>姓名</th><th>分成比例</th><th>类型</th><th>备注</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${renyuan.content}" var="renyuan">
			<tr>
				<td><a href="${ctx}/renyuan/update/${renyuan.id}">${renyuan.name}</a></td>
				<td>${renyuan.fengcheng.fcbl}</td>
				<td><c:if test="${renyuan.type == 1}">普通销售人员</c:if><c:if test="${renyuan.type==2}">直接分成人员</c:if></td>
				<td>${renyuan.bz }</td>
				<td><a href="${ctx}/renyuan/delete/${renyuan.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${renyuan}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/renyuan/save">创建人员</a></div>
</body>
</html>