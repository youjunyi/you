<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>

	<title>信息详细</title>
	<script type="text/javascript">

			</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/wx/savejj" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="lcid" value="${lc.id}"/>
		<fieldset>
		<div align="center">
			<h4>维修编号：${lc.bh}</h4>
				<input type="hidden" name="bh" id="bh" value="${lc.bh}"/>
			</div>
			<div align="center">
			<h4>服务单编号：${lc.fwfbh}</h4>
				<input type="hidden" name="bh" id="bh" value="${lc.bh}"/>
			</div>
			<legend>
			<small>手机信息</small>
			</legend>
			
				<div class="control-group">
				<label for="task_title" class="control-label">机器序列号:</label>
				<div class="controls">
				${lc.shouji.jqxlh}
				</div>
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">机器颜色:</label>
				<div class="controls">
				${lc.shouji.jqys}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器容量:</label>
				<div class="controls">
				${lc.shouji.jqrl}
					</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器型号:</label>
				<div class="controls">
				${lc.shouji.jqxh}
				</div>
			</div>	
			<legend>
			<small>客户信息</small>
			</legend>
			
			<div class="control-group">
				<label for="description" class="control-label">电话:</label>
				<div class="controls">
			${lc.shouji.dh}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">姓名</label>
				<div class="controls">
					${lc.shouji.name}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
			${lc.shouji.bz}
				</div>
			</div>	
			
			<legend>
			<small>解决方案</small>
			</legend>
			
				
			<div class="control-group">
				<label for="task_title" class="control-label">员工姓名</label>
				<div class="controls">
					${lc.jjfa.username}				
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">故障类型</label>
				<div class="controls">
				${lc.jjfa.gztype}				
			</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">质保方式</label>
				<div class="controls">
				<c:if test="${lc.jjfa.bzfs == 1}">保内</c:if>
				<c:if test="${lc.jjfa.bzfs == 2}">保外</c:if>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">维修方式</label>
				<div class="controls">
				<c:if test="${lc.jjfa.wxfs == 1}">店内</c:if>
				<c:if test="${lc.jjfa.wxfs == 2}">换机</c:if>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注</label>
				<div class="controls">
				${lc.jjfa.bz}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">完成备注</label>
				<div class="controls">
					${lc.wcbz}
				</div>
			</div>	
			<div class="form-actions">
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>