<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>商品管理</title>
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
	<thead><tr><th style="white-space:nowrap">货物号</th><th style="white-space:nowrap">名称</th><th style="white-space:nowrap">类型</th><th style="white-space:nowrap">适配型号</th><th style="white-space:nowrap">库存数量</th><th style="white-space:nowrap">供货商</th><th style="white-space:nowrap">供货时间</th><th style="white-space:nowrap">成本价</th><th style="white-space:nowrap">媒体价</th><th style="white-space:nowrap">最低价</th><th style="white-space:nowrap">管理</th><th>进货</th></tr></thead>
		<tbody>
		<c:forEach items="${shangpin.content}" var="shangpin">
			<tr><td>${shangpin.wid }</td>
				<td><a href="${ctx}/shangpin/update/${shangpin.id}">${shangpin.name}</a></td>
				<td>${shangpin.types.name}</td>
				<td>${shangpin.spxh }</td>
				<td>${shangpin.kcsl }</td>
				<td>${shangpin.ghs }</td>
				<td style="white-space:nowrap"><fmt:formatDate value="${shangpin.ghrq }" pattern="yyyy年MM月dd日" /> 
</td>
				<td>${shangpin.cb }</td>
				<td>${shangpin.mtj }</td>
				<td>${shangpin.zdj }</td>
				<td><a href="${ctx}/shangpin/delete/${shangpin.id}">删除</a></td>
			 	<td><a href="${ctx}/jinhuo/update/${shangpin.id}">进货</a></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${shangpin}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/shangpin/save">创建商品</a></div>
</body>
</html>