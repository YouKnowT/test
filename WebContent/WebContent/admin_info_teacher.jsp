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
						<h5>教师注册信息</h5>

					</div>
					
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>教师编号</th> 
										<th>教师姓名</th>
										<th>注册密码</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody> 
									<c:forEach items="${courseAll }" var="course">
										<tr>
										<td>${course.tid  }</td>
										<td>${course.name  }</td>

											<td>${course.password  }</td>
										<td>
										
								  		
										  
<!-- 												<a href="UserInfoServlet?opr=target&id=${course.id }"> -->
												<a href="teacher_modify.jsp">
														<button type="button" class="btn btn-sm btn-primary" >修改</button>
												</a> 
												<a href="UserInfoServlet?opr=coursedel&id=${course.id }">
														<button type="button" class="btn btn-sm btn-primary">删除</button>
												</a> 
												
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
    </script>




</body>

</html>
