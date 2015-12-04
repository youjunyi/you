<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
<script  type="text/javascript" src="${ctx}/static/Highcharts-4.1.5/js/highcharts.js"></script>
<script type="text/javascript" src="${ctx}/static/Highcharts-4.1.5/js/highcharts-more.js"></script>
<script type="text/javascript" src="${ctx}/static/Highcharts-4.1.5/js/highcharts-3d.js"></script>


<script type="text/javascript">
$(function () {
	var json = '${json}';
	 var json2= eval("("+json+")");
	 var json1 = '${json1}';
	 var json3= eval("("+json1+")")
	var json4 = '${json2}';
	 var json5= eval("("+json4+")")
    $('#container').highcharts({
        chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '商品库存与出售数量统计图'
        },
        xAxis: {
            categories: json2,
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '商品数量 (个)'
            }
        },
        legend: {
            enabled: true
        },
        tooltip: {
        	  headerFormat: '<span style="font-size: 10px;">{point.key}</span>',
              pointFormat: '' +
                  '',
              footerFormat: '<table><tbody><tr><td style="padding: 0px;">{series.name}: </td><td style="padding: 0px;"><b>{point.y:.1f} 个</b></td></tr></tbody></table>',
              shared: true,
              useHTML: true
      },
        series: [
                 
          {
            name: '库存数量',
            data: json3,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        },
        {
            name: '出售数量',
            data: json5,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }
        ]
    });
});


</script>
</head>

<body>
	<div id="container">
	
	</div>
</body>
</html>
