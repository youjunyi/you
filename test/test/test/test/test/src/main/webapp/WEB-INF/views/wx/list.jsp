<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>
<script type="text/javascript">
function jjfa(id){
	alert('kkk');
	$.layer({
	    type : 2,
	    title : '添加解决方案',
	    iframe : {src : '${ctx}/wx/jufa?id='+id+''},
	    area : ['700px' , '400px'],
	    offset : ['0px','']
	});
}
function quji(id){
	$.layer({
	    type : 2,
	    title : '用户取机',
	    iframe : {src : '${ctx}/wx/quji?id='+id+''},
	    area : ['700px' , '400px'],
	    offset : ['0px','']
	});
}
function xkkh(id){
	$.layer({
		type : 2,
		title : '客户信息',
		iframe : {src : '${ctx}/wx/xkkh?id='+id+''},
		area : ['700px' , '400px'],
		offset : ['0px','']
		
	});
	
}

</script>
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
	 
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>编号</th><th>服务单编号<th>型号</th><th>用户姓名</th><th>开始时间</th><th>状态</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${list}" varStatus="status" var="list">
			<tr>
				<td id="ss">${list.BH}</td>
				<td>${list.FWFBH}</td>
				<td>${list.JQXH}</td>
				<td><a href="#" onclick="xkkh(${list.SJID})">${list.NAME}</a></td>
				<td>${list.KSSJ}</td>
				<td>${list.BIAOZHI}</td>
				<c:if test="${list.BIAOZHI == '受理'}">
				<td><a href="#" onclick="jjfa(${list.LCID});">解决方案</a>
				<a href="${ctx}/wx/delete?id=${list.LCID}">删除</a></td>
				</c:if>
				<c:if test="${list.BIAOZHI == '取机'}">
				<td><a href="#" onclick="quji(${list.LCID});">用户取机</a>
				<a href="${ctx}/wx/delete?id=${list.LCID}">删除</a></td>
				</c:if>
				
				
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div><a class="btn" href="${ctx}/wx/save">创建任务</a></div>
</body>
</html>