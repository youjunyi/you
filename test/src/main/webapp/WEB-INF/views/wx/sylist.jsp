<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>

<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>
<script type="text/javascript">
function jjfa(id){
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
 function ckxx(id){
 $.layer({
		type : 2,
		title : '客户信息',
		iframe : {src : '${ctx}/wx/ckxx?id='+id+''},
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
		<div>
			<form class="form-search" action="${ctx }/wx/sylist">
			客户姓名：<input type="text" name="name" class="input-medium" value="${name}">
			序列号：<input type="text" name="xlh" class="input-medium" value="${xlh}">
			IMEI：<input type="text" name="imei" class="input-medium" value="${imei}">
			客户电话：<input type="text" name="khdh" class="input-medium" value="${khdh}">
					<br/>
			机器类型: <input type="text" name="jqlx" class="input-medium" value="${jqlx}">
			
			保修类型: <input type="text" name="bxlx" class="input-medium" value="${bxlx}">
				时间：<input type="text" id="d4311" name="kssj" class="input-medium  Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2100-10-01\'}'})" value="${kssj}"> 
				到<input type="text" id="d4312" name="jssj" class="input-medium Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2100-10-01'})" value="${jssj}"> 
			<br/>
			编号	：<input type="text" name="bh" class="input-medium" value="${name}">
			服务单编号：<input type="text" name="fwfbh" class="input-medium" value="${name}">
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	 
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>编号</th><th>服务单编号<th>机器类型</th><th>序列号</th><th>IMEI</th><th>保修类型</th><th>用户姓名</th><th>开始时间</th><th>状态</th><th>操作</th><tr></thead>
		<tbody>
		<c:forEach items="${list}" varStatus="status" var="list">
			<tr>
				<td id="ss">${list.BH}</td>
				<td>${list.FWFBH}</td>
				<td>${list.JQXH}</td>
				<td>${list.JQXLH}</td>
				<td>${list.IMEI}</td>
				<td>${list.BZFS}</td>
				<td><a href="#" onclick="xkkh(${list.SJID})">${list.NAME}</a></td>
				<td>${list.KSSJ}</td>
				<td>${list.BIAOZHI}</td>
				
				
				<td>
				<c:if test="${list.BIAOZHI == '取机'}">
				<a href="#" onclick="quji(${list.LCID});">用户取机</a>
				</c:if>
				<c:if test="${list.BIAOZHI == '受理'}">
				<a href="#" onclick="jjfa(${list.LCID});">解决方案</a>
				</c:if>
				<c:if test="${list.BIAOZHI == '完成'}">
				<a href="#" onclick="ckxx(${list.LCID});">查看信息</a>
				</c:if>
				<a href="${ctx}/wx/delete?id=${list.LCID}">删除</a>
				</td>
				
				
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>