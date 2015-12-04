<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
<script language="javascript" type="text/javascript" src="/you/static/layer/layer.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){ 
	 layer.alert('提交成功',6,'', function(){window.parent.document.location.href="${ctx}/wx/list"})
})
</script>
</head>
<body>

</body>
</html>