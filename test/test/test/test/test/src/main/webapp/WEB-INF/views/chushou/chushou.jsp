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
			$("#wid").focus();
			
		
			//为inputForm注册validate函数
			$("#inputForm").validate();
			$("#submit_btn").click(function() {
				var s = $("#chushoujia").val();
				var cs = $("#zdj").val();
				var s1 = $("#jysl").val();
				var s2 =$("#name").val();
	              if(!confirm('出售商品“'+s2+'”,数量'+ s1+'件，金额为'+s*s1+'元，请确定！！')) {
	                  return false;
	                 }
	             if(parseInt(cs)<parseInt(s)){
	              submit();
	             }else{
	            	 alert("价格太低了！！！！！");
	            	 return false;
	             }
			});
			
			/**
			$("#wid").blur(function(){
				
				var cn = $("#wid").val();
				var cx ="";
				if(null == cn || cn==cx){
					
				
				}else{
					
				$.post("chushou/buquan",{wid:cn},function(msg){
					$("#sid").val((msg.id));  
					$("#name").val((msg.name)); 
					$("#type").val((msg.type)); 
					$("#spxh").val((msg.spxh)); 
					$("#ghs").val((msg.ghs)); 
					$("#chushoujia").val((msg.mtj));
					$("#zdj").val((msg.zdj));
				},"json");	
				
				};
			});
			**/
			$("#chushoujia").blur(function(){
				var cn=$("#chushoujia").val();
				var cs = $("#zdj").val();
		
				cn*100/100;
				cs*100/100;
				if(parseInt(cn)<=parseInt(cs)){
					alert("价格低于最低价了！！！！！！")
				}
				
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/chushou/${action}" method="post" class="form-horizontal">
		<input type="hidden" id="sid" name="sid" value="${shangpin.id}"/>
		<input type="hidden" name="id" value="${shangpin.id}"/>
		<input type="hidden" id="zdj" name="shangpin.zdj" value="${shangpin.zdj }"/>
		
		<fieldset>
			<legend><small>销售商品</small></legend>
				<div class="control-group">
				<label for="task_title" class="control-label">物料号:</label>
				<div class="controls">
					<input type="text"  readonly="readonly" id="wid" name="wid"  value="${shangpin.wid}" class="input-large required" />
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
					<input type="text" id="type" readonly="readonly" name="shangpin.types.name" class="input-large"value="${shangpin.types.name}"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">适配型号:</label>
				<div class="controls">
					<input type="text" id="spxh" readonly="readonly" name="spxh" class="input-large"value="${shangpin.spxh}"/>
				</div>
			</div>	
						<div class="control-group">
				<label for="description" class="control-label">供货商:</label>
				<div class="controls">
					<input type="text" id="ghs" readonly="readonly"name="ghs" class="input-large"value="${shangpin.ghs}"/>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">出售价钱:</label>
				<div class="controls">
					<input type="text" title="${shangpin.zdj}" id="chushoujia" name="jyje" class="input-large required"value="${shangpin.mtj}"/>
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">出售数量:</label>
				<div class="controls">
					<input type="text" id="jysl" name="jysl" class="input-large required"value="${liucheng.jysl}"/>
				</div>
			</div>
			<!-- 
			<div class="control-group">
				<label for="description" class="control-label">出售人员:</label>
				<div class="controls">
				<select name="renyuans">
					<c:forEach items="${renyuan}" var="renyuan">
						<option value="${renyuan.id}">${renyuan.name }</option>
					</c:forEach>
				</select>						
				</div>
			</div>	
			 -->	
			<div class="control-group">
				<label for="description" class="control-label">缴款方式:</label>
				<div class="controls">
				<input type="radio" id="type1" name="zkfs" value="1" checked="checked"/>现金交款<input type="radio" id="type2" name="zkfs" value="2"/>POS交款
					
							</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">备注:</label>
				<div class="controls">
				<textarea id="description" name="liucheng.bz" class="input-large">${liucheng.bz}</textarea>
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
