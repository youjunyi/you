<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>

	<title>客户信息</title>

</head>

<body>
	<form id="inputForm" action="${ctx}/wx/savejj" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="lcid" value="${lc.id}"/>
		<fieldset>
			<legend>
			<small>手机信息</small>
			</legend>
			<div class="control-group">
				<label for="task_title" class="control-label">机器序列号:</label>
				${sj.jqxlh}
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">机器颜色:</label>
				<div class="controls">
				${sj.jqys}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器容量:</label>
				<div class="controls">
				${sj.jqrl}
					</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器型号:</label>
				<div class="controls">
				${sj.jqxh}
				</div>
			</div>	
			<legend>
			<small>客户信息</small>
			</legend>
			
			<div class="control-group">
				<label for="description" class="control-label">电话:</label>
				<div class="controls">
			${sj.dh}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">姓名</label>
				<div class="controls">
					${sj.name}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">身份证编号</label>
				<div class="controls">
					${sj.cid}
				</div>
			</div>
				<div class="control-group">
				<label for="description" class="control-label">备用联系人</label>
				<div class="controls">
					${sj.bylxr}
				</div>
			</div>	
				<div class="control-group">
				<label for="description" class="control-label">备用联系电话</label>
				<div class="controls">
					${sj.bylxrdh}
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
			${sj.bz}
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" onclick="tj(${lc.id});" class="btn btn-primary" type="button" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>