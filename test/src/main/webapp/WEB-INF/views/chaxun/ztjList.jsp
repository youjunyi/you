<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
	<title>统计查询</title>
		<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		var t1 = $("#t1 tr");
		var e1 =0.00;
		var l1=0.00;
		var l2=0.00;
		var l3=0.00;
		var l4=0.00;
		var l5=0.00;
		for(var i=0;i<t1.length;i++){
			i++;
			var s = 0.00; 
			s = $("#e"+i+"").val();
			e1= e1*1+s*1;
			//var s1 = 0.00;
				s = $("#l"+i+"").val();
			l1= l1*1+s*1;
			//var s2 =0.00;
			s= $("#l1"+i+"").val();
			l2= l2*1+s*1;
			//var s3 = 0.00;
			s = $("#s"+i+"").val();
			l3 = l3*1+s*1;
			s = $("#sl"+i+"").val();
			l4 = l4*1+s*1;
			s = $("#sy"+i+"").val();
			l5 = l5*1+s*1;
			i--;
		}
		var l6=l5.toFixed(2);
		var l7=l4.toFixed(2);
		var l8=l3.toFixed(2);
		$("#e").text(e1);
		$("#l").text(l1);
		$("#s").text(l2);
		$("#y").text(l8);
		$("#z").text(l7);
		$("#k").text(l6);
	})
	
	</script>
</head>
<body>
<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div>
		<div>
			<form class="form-search" action="#">
				名称：<input type="text" name="search_LIKE_shangpinName" class="input-medium" value="${searchParams.LIKE_shangpinName}"> 
				销售员：<input type="text" name="search_LIKE_renyuanNname" class="input-medium" value="${searchParams.LIKE_renyuanNname}"> 
				销售时间:<input type="text" id="d4311" name="search_GTE_czsj" class="input-medium  Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2100-10-01\'}'})" value="${searchParams.GTE_czsj}"> 
				到<input type="text" id="d4312" name="search_LTE_czsj" class="input-medium Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2100-10-01'})" value="${searchParams.LTE_czsj}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr><th>序号</th><th style="white-space:nowrap">货物号</th><th style="white-space:nowrap">名称</th><th style="white-space:nowrap">类型</th><th style="white-space:nowrap">适配型号</th><th>金额</th><th nowrap="nowrap">数量</th><th>利润</th><th nowrap="nowrap">销售人员分成</th><th nowrap="nowrap">公司分成</th><th nowrap="nowrap">实际利润</th><th nowrap="nowrap">销售人员</th><th>销售时间</th></tr></thead>
		<tbody id="t1">
		<c:forEach items="${liucheng}" varStatus="status" var="liucheng">
			<tr id="tr">
				<td>${status.index + 1}</td>
				<td>${liucheng.shangpin.wid}</td>
				<td nowrap="nowrap">${liucheng.shangpin.name}</td>
				<td>${liucheng.shangpin.type}</td>
				<td>${liucheng.shangpin.spxh }</td>
				<td>${liucheng.jyje }<input id="e${status.index + 1}" type="hidden" value="${liucheng.jyje }"/></td>
				<td>${liucheng.jysl }<input id="l${status.index + 1}" type="hidden" value="${liucheng.jysl }"/></td>
				<td>${liucheng.lr}<input id="l1${status.index + 1}" type="hidden" value="${liucheng.lr }"/></td>
				<td>${liucheng.lr*liucheng.user.fengcheng.fcbl/100}<input id="s${status.index + 1}" type="hidden" value="${liucheng.lr*liucheng.user.fengcheng.fcbl/100}"/></td>
				<td><fmt:formatNumber value="${liucheng.lr*fengcheng.fcbl/100}" pattern="#,#00.0#"/><input id="sl${status.index + 1}" type="hidden" value="${liucheng.lr*fengcheng.fcbl/100}"/></td>
				<td><fmt:formatNumber value="${liucheng.lr - liucheng.lr*liucheng.user.fengcheng.fcbl/100 - liucheng.lr*fengcheng.fcbl/100}" pattern="#,#00.0#"/><input id="sy${status.index + 1}" type="hidden" value="${liucheng.lr - liucheng.lr*liucheng.user.fengcheng.fcbl/100 - liucheng.lr*0.2}"/></td>
				<td>${liucheng.user.name }</td>
				<td nowrap="nowrap">${liucheng.czsj}</td>
			</tr>
		</c:forEach>
		
		<tbody>
		<tr>
			<td>统计</td>
			<td colspan="4"></td>
			<td id="e"></td>
			<td id="l"></td>
			<td id="s"></td>
			<td id="y"></td>
			<td id="z"></td>
			<td id="k"></td>
			<td id=""></td>
			<td></td>
			</tr>
		</tbody>
		</tbody>
	</table>
	

	<div><a class="btn" href="${ctx}/chushou">出售商品</a></div>
</body>
</html>