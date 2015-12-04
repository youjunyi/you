<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>AppleCare服务系统 :</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
    <title>后台管理系统</title>
    <link type="text/css" href="${ctx }/static/Stylesw/admin-all.css"  rel="stylesheet" />
    <link type="text/css" href="${ctx }/static/Stylesw/base.css"  rel="stylesheet" />
    <link  type="text/css" href="${ctx }/static/Stylesw/bootstrap.min.css"  rel="stylesheet" />
    <link type="text/css" href="${ctx }/static/Stylesw/ui-lightness/jquery-ui-1.8.22.custom.css"  rel="stylesheet" />
    <script type="text/javascript" src="${ctx }/static/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctx }/static/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="${ctx }/static/Scripts/index.js"></script>
</head>
<body>
   
  
     <div>
   <div class="top-nav">欢迎您， <shiro:principal property="name"/>！&nbsp;&nbsp;| <a href="${ctx}/logout">安全退出</a></div>
        <!--头部结束-->
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>系统操作菜单</h1>
            <div >
                <div>
                    <a class="one">用户管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/admin/user">用户管理</a></li>
                        
                    	
                    </ul>
                </div>
                <div>
                    <a class="one">商品管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/listcos">商品管理</a></li>
                    
                    </ul>
                </div>
                <div>
                    <a class="one">商品类型管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/listctype">商品类型管理</a></li>
                      
                    </ul>
                </div>
                <div>
                    <a class="one">咨讯管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/spzx">咨讯管理</a></li>
                      
                    </ul>
                </div>
               <div>
                    <a class="one">订单发货管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/getmyorder">订单发货管理</a></li>
                      
                    </ul>
                </div>
                 <div>
                    <a class="one">建议反馈</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/getAdvice">建议反馈</a></li>
                    </ul>
                </div>
                 <div>
                    <a class="one">统计</a>
                    <ul class="kid">
                         <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/typetj">商品数量统计表</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/getAdvice">已发货订单统计</a></li>
                       <li><b class="tip"></b><a target="Conframe" href="${ctx}/gl/getAdvice">商品数量统计图</a></li>
                    </ul>
                </div>
                
                <div id="datepicker"></div>
            </div>

        </div>
        <!--左边菜单结束-->
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>

        </div>
        <div class="Conframe">
            <iframe name="Conframe" id="Conframe"></iframe>
        </div>
        <!--右边框架结束-->

        <!--底部开始-->
      
        <!--底部结束-->
  </div>  
</body>
</html>
