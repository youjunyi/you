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
	<form id="inputForm" action="${ctx}/gl/${action}" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="zixun_type_id" value="${zixun.zixun_type_id}"/>
		<fieldset>
			<legend><small>资讯管理</small></legend>
			<div class="control-group">
				<label class="control-label">标题:</label>
				<div class="controls">
					<input type="text" name="title" value="${zixun.title}" class="input-large"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">内容:</label>
				<div class="controls">
					<textarea rows="5" cols="20" name="content"  class="input-large"> ${zixun.content}</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">类型：</label>
				<div class="controls">
					<select name="zixun_type">
					<option value="1">国内资讯</option>
					<option value="2">国际资讯</option>
					<option value="3">化妆品动态</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">图片:</label>
				<div class="controls">
				 <input type="file" name="file" />	
				</div>
			</div>
			<div class="control-group">
			<div class="controls">
			<img src="${ctx}${zixun.img_url }" style="width:300px"/>  
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
