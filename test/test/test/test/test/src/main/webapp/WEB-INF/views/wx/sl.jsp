<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<script language="javascript" type="text/javascript" src="/you/static/rq/My97DatePicker/WdatePicker.js"></script>
	<title>业务受理</title>
	<script type="text/javascript">
	
	function dayin(bh){
		window.open("${ctx}/wx/dayin?bh="+bh);
		$("#submit_btn").attr("disabled", false);

	}
	
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/wx/saveup" method="post" enctype="multipart/form-data" class="form-horizontal">
		<input type="hidden" name="id" value="${shangpin.id}"/>
					<div align="center">
				<h4>维修编号：${bh}</h4>
				<input type="hidden" name="bh" id="bh" value="${bh}"/>
				<label for="task_title" class="control-label">服务单编号：</label>
				<div class="controls">
					<input type="text"" name="fwfbh" id="fwfbh" value="${fwfbh}" class="input-large required"/>
				</div>
				
			</div>
		<fieldset>

			<legend>
			<small>手机信息</small>
			</legend>
				
				
				<div class="control-group">
				<label for="task_title" class="control-label">机器序列号:</label>
				<div class="controls">
					<input type="text" id="jqxlh" name="jqxlh"  value="${jqxlh}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">IMEI:</label>
				<div class="controls">
					<input type="text" id="imei" name="imei"  value="${imei}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="task_title" class="control-label">机器颜色:</label>
				<div class="controls">
					<input type="text" id="jqys" name="jqys"  value="${jqys}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器容量:</label>
				<div class="controls">
					<input type="text" id="jqrl" name="jqrl"  value="${jqrl}" class="input-large required" />
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器型号:</label>
				<div class="controls">
					<input type="text" id="jqxh" name="jqxh" class="input-large required"value="${jqxh}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">机器外观:</label>
				<div class="controls">
					<input type="text" id="jqwg" name="jqwg" class="input-large required"value="${jqwg}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">保修截至:</label>
				<div class="controls">
					<input type="text" id="bxjz" name="bxjz" class="input-large  Wdate" value="${bxjz}" onClick="WdatePicker()"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">送修日期:</label>
				<div class="controls">
					<input type="text" id="sxrq" name="sxrq" class="input-large  Wdate" value="${sxrq}" onClick="WdatePicker()"/>
				</div>
			</div>	
			<legend>
			<small>客户信息</small>
			</legend>
			
			<div class="control-group">
				<label for="description" class="control-label">电话:</label>
				<div class="controls">
					<input type="text" id="dh" name="dh" class="input-large"value="${dh}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">姓名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" class="input-large" value="${name}" />
					
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">身份证号:</label>
				<div class="controls">
					<input type="text" id="cid" name="cid" class="input-large" value="${cid}" />
					
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">邮件:</label>
				<div class="controls">
					<input type="text" id="emal" name="emal" class="input-large required"value="${emal}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">地址:</label>
				<div class="controls">
					<input type="text" id="dz" name="dz" class="input-large required"value="${dz}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备用联系人:</label>
				<div class="controls">
					<input type="text" id="bylxr" name="bylxr" class="input-large required"value="${bylxr}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备用联系人电话:</label>
				<div class="controls">
					<input type="text" id="bylxrdh" name="bylxrdh" class="input-large required"value="${bylxrdh}"/>
				</div>
			</div>	
			<div class="control-group">
			<label for="description" class="control-label">备注:</label>
			<div class="controls">
					<select name="type">
					<option value="个人">个人</option>
					<option value="企业">企业</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
					<textarea rows="" cols="" name="bz"></textarea>
				</div>
			</div>	
			<div class="form-actions">
				<input id="butn" class="btn btn-primary" type="button" onclick="dayin('${bh}');" value="打印"/>
				<input id="submit_btn" class="btn btn-primary" disabled = "true" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
