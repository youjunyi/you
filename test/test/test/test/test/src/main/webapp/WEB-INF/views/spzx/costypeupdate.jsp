<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</head>
<body>
	<form id="inputForm" action="${ctx}/gl/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="type_id" value="${costype.type_id}"/>
		<fieldset>
			<legend><small>类型管理</small></legend>
			<div class="control-group">
				<label class="control-label">类型名称:</label>
				<div class="controls">
					<input type="text" name="type_name" value="${costype.type_name}" class="input-large"/>
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
