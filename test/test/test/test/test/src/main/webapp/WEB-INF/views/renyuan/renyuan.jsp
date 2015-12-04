<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>折扣添加页</title>
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
	<form id="inputForm" action="${ctx}/renyuan/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${renyuan.id}"/>
		<fieldset>
			<legend><small>折扣添加</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">姓名:</label>
				<div class="controls">
					<input type="text" id="task_name" name="name"  value="${renyuan.name}" class="input-large required"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">类型:</label>
				<div class="controls">
					<input type="radio" id="type1" name="type" value="1" checked="checked"/>普通销售人员<input type="radio" id="type2" name="type" value="2"/>直接分成人员
					<script type="text/javascript">
						var s = document.getElementById("type1");
						var s1 = document.getElementById("type2");
						var ss = s.value;
						var ss1 = s1.value;
						if(ss == ${renyuan.type}){
							s.checked=true;
						}else{
							s1.checked=true;
						}
 
					
					</script>
				</div>
			</div>
			<div class="control-group">
			<label for="description" class="control-label">分成选择:</label>
				<div class="controls">
				<select name="fengchengs">
				<option value="${renyuan.fengcheng.id}" title="${renyuan.fengcheng.fcbl}">${renyuan.fengcheng.name }</option>
					<c:forEach items="${fengcheng}" var="fengcheng">
						<option value="${fengcheng.id}" title="${fengcheng.fcbl}">${fengcheng.name }</option>
					</c:forEach>
				</select>
				
				</div>
			</div>
			
				
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
					<textarea id="description" name="bz" class="input-large">${renyuan.bz}</textarea>
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
