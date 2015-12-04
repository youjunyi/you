<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>

	<title>分成添加页</title>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					wid:{
						remote: "${ctx}/shangpin/checkWid?oldWid=" + encodeURIComponent('${shangpin.wid}')
					},
					
					name:{
						remote: "${ctx}/shangpin/checkName?oldName=" + encodeURIComponent('${shangpin.name}')
					}
				},
				messages: {
					wid: {
						remote: "物料号已存在"
					},
					name:{
						remote: "名称已存在"
					}
				}	
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/shangpin/${action}" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="id" value="${shangpin.id}"/>
		<fieldset>
			<legend><small>商品添加</small></legend>
				<div class="control-group">
				<label for="task_title" class="control-label">物料号:</label>
				<div class="controls">
					<input type="text" id="wid" name="wid"  value="${shangpin.wid}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">名称:</label>
				<div class="controls">
					<input type="text" id="name" name="name"  value="${shangpin.name}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">类型:</label>
				<div class="controls">
				<select name="typex">
				<option value="${shangpin.types.id}" title="${shangpin.types.bz}">${shangpin.types.name }</option>
					<c:forEach items="${type}" var="type">
						<option value="${type.id}" title="${type.bz}">${type.name }</option>
					</c:forEach>
				</select>
				
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">适配型号:</label>
				<div class="controls">
					<input type="text" id="spxh" name="spxh" class="input-large required"value="${shangpin.spxh}"/>
				</div>
			</div>	
						<div class="control-group">
				<label for="description" class="control-label">供货商:</label>
				<div class="controls">
					<input type="text" id="ghs" name="ghs" class="input-large"value="${shangpin.ghs}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">供货日期</label>
				<div class="controls">
					<input type="text" id="ghrq" name="ghrq" class="input-large  Wdate" value="${shangpin.ghrq}" onClick="WdatePicker()"/>
					
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">成本价:</label>
				<div class="controls">
					<input type="text" id="cb" name="cb" class="input-large required"value="${shangpin.cb}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">媒体价:</label>
				<div class="controls">
					<input type="text" id="mtj" name="mtj" class="input-large required"value="${shangpin.mtj}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">最低价:</label>
				<div class="controls">
					<input type="text" id="zdj" name="zdj" class="input-large required"value="${shangpin.zdj}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">商品图片:</label>
				<div class="controls">
				 <input type="file" name="file" />	
				</div>
			</div>
			<div class="control-group">
			<div class="controls">
			<img src="${ctx}${shangpin.path }" style="width:300px"/>  
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
