<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>分成添加页</title>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#task_name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/type/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${type.id}"/>
		<fieldset>
			<legend><small>分成添加</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">类型名称:</label>
				<div class="controls">
					<input type="text" id="task_name" name="name"  value="${type.name}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
					<textarea id="description" name="bz" class="input-large">${type.bz}</textarea>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
