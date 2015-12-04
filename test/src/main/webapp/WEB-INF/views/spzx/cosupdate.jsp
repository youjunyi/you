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
		<input type="hidden" name="cosmetics_id" value="${cos.cosmetics_id}"/>
		<fieldset>
			<legend><small>商品管理</small></legend>
			<div class="control-group">
				<label class="control-label">化妆品名称:</label>
				<div class="controls">
					<input type="text" name="cosmetics_name" value="${cos.cosmetics_name}" class="input-large"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">化妆品库存数:</label>
				<div class="controls">
					<input type="text" name="cosmetics_count" value="${cos.cosmetics_count}" class="input-large"/>
				</div>
			</div>
				<div class="control-group">
				<label class="control-label">销售价:</label>
				<div class="controls">
					<input type="text" name="cosmetics_sale_price" value="${cos.cosmetics_sale_price}" class="input-large"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">销售数量:</label>
				<div class="controls">
					<input type="text" name="cosmetics_sale_count" value="${cos.cosmetics_sale_count}" class="input-large"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">市场价:</label>
				<div class="controls">
					<input type="text" name="cosmetics_market_price" value="${cos.cosmetics_market_price}" class="input-large"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">类型：</label>
				<div class="controls">
					<select name="typex">
					<option value="${cos.cosmeticstype.type_id}" >${cos.cosmeticstype.type_name}</option>
					<c:forEach items="${cosmeticType}" var="type">
						<option value="${type.type_id}" >${type.type_name }</option>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">详情:</label>
				<div class="controls">
					<textarea rows="5" cols="20" name="cosmetics_detail"  class="input-large"> ${cos.cosmetics_detail}</textarea>
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
			<img src="${ctx}${cos.cosmetics_img }" style="width:300px"/>  
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
