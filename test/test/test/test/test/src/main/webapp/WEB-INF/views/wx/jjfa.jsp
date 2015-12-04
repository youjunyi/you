<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>

	<title>解决方案</title>
	<script type="text/javascript">

	function tj(){
		layer.confirm('确定提交',function(){
			 $("#inputForm").submit();
		});
	 
		
	}
	
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/wx/savejj" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="lcid" value="${lc.id}"/>
		<fieldset>
			<legend>
			<small>解决方案</small>
			</legend>
			
				
			<div class="control-group">
				<label for="task_title" class="control-label">员工姓名</label>
				<div class="controls">
					<input type="text" id="username" name="username"  value="${user.name}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">故障类型</label>
				<div class="controls">
					<input type="text" id="gztype" name="gztype"  value="${gztype}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">质保方式</label>
				<div class="controls">
				<input type="radio" name="bzfs" value="1">保内 <input name="bzfs" type="radio" value="2">保外
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">维修方式</label>
				<div class="controls">
					<input type="radio" name="wxfs" value="1">店内 <input name="wxfs" type="radio" value="2">换机
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注</label>
				<div class="controls">
						<textarea rows="" cols="" name="bz"></textarea>
				</div>
			</div>	
			
			<div class="form-actions">
				<input id="submit_btn" onclick="tj();" class="btn btn-primary" type="button" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
