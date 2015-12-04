
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>

	<title>进货页</title>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#wid").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/jinhuo/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${shangpin.id}"/>
		<fieldset>
			<legend><small>进货</small></legend>
				<div class="control-group">
				<label for="task_title" class="control-label">物料号:</label>
				<div class="controls">
					<input type="text" readonly="readonly" id="wid" name="wid"  value="${shangpin.wid}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">名称:</label>
				<div class="controls">
					<input type="text" readonly="readonly" id="name" name="name"  value="${shangpin.name}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">类型:</label>
				<div class="controls">
					<input type="text" readonly="readonly" id="type" name="shangpin.type" class="input-large"value="${shangpin.type}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">适配型号:</label>
				<div class="controls">
					<input type="text" readonly="readonly" id="spxh" name="spxh" class="input-large"value="${shangpin.spxh}"/>
				</div>
			</div>	
						<div class="control-group">
				<label for="description" class="control-label">供货商:</label>
				<div class="controls">
					<input type="text" readonly="readonly" id="ghs" name="ghs" class="input-large"value="${shangpin.ghs}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">供货日期</label>
				<div class="controls">
					<input type="text" id="ghrq" readonly="readonly" name="ghrq" class="input-large  Wdate" value="${shangpin.ghrq}" onClick="WdatePicker()"/>
					
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">成本价:</label>
				<div class="controls">
					<input type="text" id="cb" name="cb" class="input-large"value="${shangpin.cb}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">媒体价:</label>
				<div class="controls">
					<input type="text" id="mtj" name="mtj" class="input-large"value="${shangpin.mtj}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">最低价:</label>
				<div class="controls">
					<input type="text" id="zdj" name="zdj" class="input-large"value="${shangpin.zdj}"/>
				</div>
			</div>			
			<div class="control-group">
				<label for="description" class="control-label">库存数量:</label>
				<div class="controls">
					<input type="text" id="kcsl" name="kcsl" class="input-large"value="${shangpin.kcsl}"/>
				</div>
			</div>	
				<div class="control-group">
				<label for="description" class="control-label">进货数量:</label>
				<div class="controls">
					<input type="text" id="jysl" name="jysl" class="input-large required"value="${liucheng.jysl}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">进货金额:</label>
				<div class="controls">
					<input type="text" id="jyje" name="jyje" class="input-large required"value="${liucheng.jyje}"/>
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
				<textarea id="description" name="bz" class="input-large">${liucheng.bz}</textarea>
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
