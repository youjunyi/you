<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
function print(print){
var myDate = new Date();  
var hkey_root, hkey_path, hkey_key;
hkey_root = "HKEY_CURRENT_USER";
hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
  
var headstr = "<html><head><title></title></head><body>";
var footstr = "</body>";

var newstr = document.all.item(print).innerHTML;
var oldstr = document.body.innerHTML;

document.body.innerHTML = headstr + newstr + footstr;
window.print(); 
document.body.innerHTML = oldstr;
})

</script>
</head>
<body >
<input type="button" value="打印" onclick="print('print');">
<div id="print">
<h3>维修编号：${bh}</h3>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好：</br>
&nbsp;&nbsp;&nbsp;&nbsp;感谢您对本店的支持，您送往本店维修的机器本店已受理，您可以在7个工作日后凭借本单据来本店取机。</br>
请您保管好此单据作为您的取机凭证</br>
</br>
</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：<span id="date"></span>
</div>

</body>

</html>