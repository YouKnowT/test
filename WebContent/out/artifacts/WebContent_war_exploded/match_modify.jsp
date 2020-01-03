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
<style>
        th{
            width: 8px;
        }
    </style>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>录入信息管理</h5>
						</div>
						<div class="ibox-content">
						<div class="row">
								<form action="UserInfoServlet?opr=selectuser" method="post">
							<div class="col-sm-9">
								<div class="input-group">
									<input type="text" placeholder="请输入要搜索的账号"
										class="input-sm form-control" name="param"> <span
										class="input-group-btn" >
										<button type="submit" class="btn btn-sm btn-primary">
											搜索</button>
									</span>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="input-group">
									<a href="admin_add_info.jsp">
										<button type="button" class="btn btn-sm btn-primary">
											新增</button>
									</a>
								</div>
							</div>
							
								</form>
								
						</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="ibox-content"> 
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>所属班级</th>
										<th>学生姓名</th>
										<th>学号</th> 
										<th>指导教师</th> 
										<th>比赛名称</th>
										<th>比赛类别</th>
										<th>比赛等级</th>
										<th>竞赛证书</th>
										<th>指导证书</th>
										<th>比赛照片</th>
										<th>操作</th>
									</tr>
									
								</thead>
								<tbody> 
									<c:forEach items="${thisscoreall }" var="target">
										<tr>
										<td>${target.class_name }</td> 
										<td>${target.course_name }</td> 
										<td>${target.target }</td> 
										<td>${target.scoure }</td> 
										<td>${target.scoure_content }</td> 
										<td>${target.class_name }</td> 
										<td>${target.course_name }</td> 
										<td>${target.target }</td> 
										<td>${target.scoure }</td> 
										<td>${target.scoure_content }</td> 
										<td>
											<a href="admin_add_info.jsp">
														<button type="button" class="btn btn-sm btn-primary" >修改</button>
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
