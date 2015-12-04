<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>进货查询</title>
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
		$("#e").text(e1+"元");
		$("#l").text(l1+"个");
	})
	
	</script>
</head>
<body>
<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>名称：</label> <input type="text" name="search_LIKE_shangpin.name" class="input-medium" value="${param.search_LIKE_shangpin.name}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr><th>序号</th><th style="white-space:nowrap">货物号</th><th style="white-space:nowrap">名称</th><th style="white-space:nowrap">类型</th><th style="white-space:nowrap">适配型号</th><th>供货商</th><th>进货数量</th><th>进货金额</th><th>进货时间</th></tr></thead>
		<tbody id="t1">
		<c:forEach items="${liucheng.content}" var="liucheng" varStatus="status">
			<tr id="tr">
			<td>${status.index + 1}</td>
			<td>${liucheng.shangpin.wid }</td>
			<td>${liucheng.shangpin.name}</td>
			<td>${liucheng.shangpin.type}</td>
			<td>${liucheng.shangpin.spxh }</td>
			<td>${liucheng.shangpin.ghs }</td>
			<td>${liucheng.jysl }个 <input id="l${status.index + 1}" type="hidden" value="${liucheng.jysl }"/></td>
			<td>${liucheng.jyje }元 <input id="e${status.index + 1}" type="hidden" value="${liucheng.jyje }"/></td>
			<td>${liucheng.czsj }</td>
			</tr>
		</c:forEach>
		
		</tbody>
		<tbody>
		<tr>
			<td>统计</td>
			<td colspan="5"></td>
			<td id="l"></td>
			<td id="e"></td>
			<td></td>
			</tr>
		</tbody>
	</table>
	
	<div><a class="btn" href="${ctx}/shangpin">商品</a></div>
</body>
</html>