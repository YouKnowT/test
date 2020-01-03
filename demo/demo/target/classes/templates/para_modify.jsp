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
						<h5>参数的录入和修改</h5>

					</div>
					 
					 
					  
					<div class="ibox-content"> 
						<div class="table-responsive" >
							<table class="table table-striped" >
								<thead align="center">
									<tr>
									
									<th>类别</th><th></th><th colspan="4" >A类</th>
									<th colspan="4">B类</th>
									<th colspan="4">C类</th>
									<th>其它</th>
									</tr>
									<tr>
									<th>项目</th><th></th><th>一等奖</th><th>二等奖</th><th>三等奖</th><th>其它</th>
									<th>一等奖</th><th>二等奖</th><th>三等奖</th><th>其它</th><th>一等奖</th><th>二等奖</th><th>三等奖</th><th>其它</th><th></th>
									</tr>
										<tr>
										<th rowspan="2">参数</th><th>基数</th><th colspan="4">0.119</th><th colspan="4">0.045</th><th colspan="4">0.01</th><th></th>
										<tr>
										<th>系数</th><th>2</th><th>1.2</th><th>1</th><th>0.5</th><th>2</th><th>1.2</th><th>1</th><th>0.5</th><th>2</th><th>1.2</th><th>1</th><th></th><th></th>
										</tr>
										
									
								
										
								</thead>


							</table>
							<div class="form-group">
                                <div class="col-sm-2 col-sm-offset-1">
                                    <button class="btn btn-primary" type="submit" name="sub" value="0">修改</button>
                                </div>
                                 <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit" name="sub" value="1">保存内容</button>
                                </div>
                                
                                
                            </div>
                            </div>
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
