<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>商品管理</title>

<script type="text/javascript">
$(document).ready(function() {
	$("#tj").click(function() {
		$("#fm").submit();
	});
	
	
	
});


</script>
<style type="text/css">

body { font-family:Helvetica, Arial, sans-serif; padding-top:50px; }
#container { margin:0 auto; width:980px; }
 
	#nav {
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#cacaca), to(#848484));
	background: -moz-linear-gradient(top, #cacaca, #848484);
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.3);
	display: inline-block;
	list-style: none;
	margin: 0 0 20px;
	overflow: hidden;
	padding: 0;
	height: 36px;
	}

#nav li { border-right:1px solid #808080; -webkit-box-shadow:inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 0 0 1px rgba(255,255,255,.1); float:left; }
#nav li a { color:#262626; display:block; font:13px "Lucida Sans Unicode", "Lucida Grande", sans-serif; height:36px; line-height:34px; padding:0 30px; text-decoration:none; text-shadow:0 1px #cecece; }
#nav li a:hover { background:-webkit-gradient(linear, 0 0, 0 100%, from(#929292), to(#535353)); background:-moz-linear-gradient(top, #929292, #535353); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 -1px #414141; }
#nav li a:active { -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); }
#nav li .apple { padding:0; }
#nav li .apple:hover { -moz-border-radius-topleft:3px; -moz-border-radius-bottomleft:3px; -webkit-border-top-left-radius:3px; -webkit-border-bottom-left-radius:3px; }
#nav li .apple span { background:url(static/images/apple.png) center 6px no-repeat; display:block; padding:0; text-indent:-99999em; width:102px; }
#nav li .current,
#nav li .current:hover { background:-webkit-gradient(linear, 0 0, 0 100%, from(#373737), to(#525051)); background:-moz-linear-gradient(top, #373737, #525051); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 1px #242323; }
#nav .search_container { border-right:none; padding-right:5px; height: 36px;}
#nav .search { background:url(static/images/search.png) right -53px no-repeat; padding:7px 20px 8px 5px; height: 20px;}
#nav .search label { background:url(static/images/search.png) 0 0 no-repeat; display:block; height:20px; }
#nav .search input { border:none; color:#a9a9a9; height:12px; margin-left:25px; -webkit-appearance:none; }
#nav .search input:focus { border:none; outline:none; }
#nav .search.focus { background-position:right -83px; padding:3px 20px 2px 5px; }
#nav .search.focus label { background-position:0 -26px; height:27px; padding-top:4px; }

h1 { margin-bottom:0; }
.read_article { color:#777; display:block; font-size:12px; margin-bottom:30px; }
</style>
</head>
<body>
<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>

		<ul id="nav">  
		 <li><a href="chushou" class="apple"><span>Apple</span></a></li>
		<c:forEach items="${type}" varStatus="status" var="type">
		<li><a href="chushou?name=${type.name}">${type.name }</a></li>
		</c:forEach>
		 <li class="search_container">        
		  <form class="search form-search" action="#" id="fm">
		  <label for="search" id="tj" >                
		  <input type="text" id="search" placeholder="Search" name="search_LIKE_wid" class="input-medium" value="${param.search_LIKE_wid}"/>         
		 </label>         
		 </form>    
		 </li> 
		 </ul> 
	
		
			
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr><th>商品</th><th style="white-space:nowrap">商品详细</th><th>出售</th></tr></thead>
		<tbody>
		<c:forEach items="${shangpin.content}" var="shangpin">
		<tr>
		<td width="310px"><img src="${ctx}${shangpin.path }" style="width:300px; height:170px "/> </td>
		<td>名称：${shangpin.name } <br/> 货物号：${shangpin.wid }<br/> 类型：${shangpin.types.name } <br/>适配型号${shangpin.spxh }</td>
		<td><a href="${ctx}/chushou/chushoua/${shangpin.id}">出      售</a></td>
		</tr>
		</c:forEach>
		
		</table>
		<tags:pagination page="${shangpin}" paginationSize="5"/>
</body>
</html>