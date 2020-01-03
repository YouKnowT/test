<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>- 基础表格</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>成绩结果统计</h5>

					</div>
					<div class="ibox-content">
						<div class="row">
							  
							<div class="col-sm-1">
								<div class="input-group"> 
										<button type="button" class="btn btn-sm btn-primary" onclick="ExcelExport()">
											导出结果</button> 
								</div>
								
								
							</div>
							
							 
						</div>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>学号</th>
										<th>姓名</th>
										<th>基数</th>
										<th>系数</th>
										<th>计算结果</th>
										
									</tr>
								</thead>
								<tbody> 
									<c:forEach items="${scoresvg }" var="svg">
										<tr>
										<td>${svg.grade}</td>
										<td>${svg.class_name  }<!-- <span class="pie">4,9</span> --></td>
										<td>${svg.courseCount }</td>
										 <td>${svg.targetCount }</td>
										 <td> 
										 
											 ${svg.scoreAvg }
										 </td>
										 
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>



	<!-- Peity -->
	<script src="js/plugins/peity/jquery.peity.min.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>


	<!-- iCheck -->
	<script src="js/plugins/iCheck/icheck.min.js"></script>

	<!-- Peity -->
	<script src="js/demo/peity-demo.js"></script>

	<script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
        /**
         * 导出
         */
        function ExcelExport(){
            var url="./ExcelExportServlet";
            window.open(url);
        }
    </script>




</body>

</html>
