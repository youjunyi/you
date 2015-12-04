<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>商品管理</title>
	<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		var t1 = $("#t1 tr");
		var e1 =0.00;
		var l1=0.00;
		for(var i=0;i<t1.length;i++){
			i++;
			var s = 0.00; 
			s = $("#e"+i+"").val();
			e1= e1*1+s*1;
			var s1 = 0.00
				s1 = $("#l"+i+"").val();
			l1= l1*1+s1*1;
			i--;
		}
		$("#e").text(e1);
		$("#l").text(l1);
	})
	
	</script>
</head>
<body>
<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div>
		<div >
			<form class="form-search" action="#">
				名称：<input type="text" name="search_LIKE_shangpin.name" class="input-medium" value="${param.search_LIKE_shangpin.name}"> 
				销售员：<input type="text" name="search_LIKE_user.name" class="input-medium" value="${param.search_LIKE_user.name}"> 
				
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr><th>序号</th><th style="white-space:nowrap">货物号</th><th style="white-space:nowrap">名称</th><th style="white-space:nowrap">类型</th><th style="white-space:nowrap">适配型号</th><th>金额</th><th>数量</th><th>交款方式</th><th>销售人员</th><th>状态</th><shiro:hasRole name="admin"><th>操作</th></shiro:hasRole></tr></thead>
		<tbody id="t1">
		<c:forEach items="${liucheng.content}" varStatus="status" var="liucheng">
			<tr id="tr">
				<td>${status.index + 1}</td>
				<td>${liucheng.shangpin.wid }</td>
				<td>${liucheng.shangpin.name}</td>
				<td>${liucheng.shangpin.type}</td>
				<td>${liucheng.shangpin.spxh }</td>
				<td>${liucheng.jyje }<input id="e${status.index + 1}" type="hidden" value="${liucheng.jyje }"/></td>
				<td>${liucheng.jysl }<input id="l${status.index + 1}" type="hidden" value="${liucheng.jysl }"/></td>
				<td><c:if test="${liucheng.zkfs==1 }">现金</c:if><c:if test="${liucheng.zkfs==2 }">POS机</c:if></td>
				<td>${liucheng.user.name }</td>
				<td><c:if test="${liucheng.zt==1 }">未对账</c:if><c:if test="${liucheng.zt==2 }">以对账</c:if></td>
				<shiro:hasRole name="admin">
				<td><a href="${ctx}/duizhang/update/${liucheng.id}">对账</a></td>
				</shiro:hasRole>
			</tr>
		</c:forEach>
		
		<tbody>
		<tr>
			<td>统计</td>
			<td colspan="4"></td>
			<td id="e"></td>
			<td id="l"></td>
			<td></td>
			</tr>
		</tbody>
		</tbody>
	</table>
	
	<tags:pagination page="${liucheng}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/chushou">出售商品</a></div>
</body>
</html>