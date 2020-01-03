<%@ page language="java" contentType="text/html; charset=UTF-8"
<%-- 	pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>学生竞赛系统管理主页</title>

<meta name="keywords" content="">
<meta name="description" content="">

<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"
									style="font-size: 20px;"> <i class="fa fa-area-chart"></i>
										
								</span>
							</span>
							</a>
						</div>
						<div class="logo-element">学生竞赛系统管理</div>
					</li>
				


					<br>
					<c:if test="${users==null }">

						<li><a href="login.html">返回登录页面</a></li>
					</c:if>
					<br>
					<c:if test="${users!=null }">

						<c:if test="${users.user_identity==0 }">
							<li><a class="J_menuItem"
							href="teacher_add_info.jsp">录入比赛信息</a></li>
<!-- 								
								href="UserInfoServlet?opr=usermanager">录入比赛信息</a></li> -->
							<li><a class="J_menuItem"
							href="info_show.jsp">查看参加的比赛</a></li>
<!-- 								href="UserInfoServlet?opr=classall">查看参加的比赛</a></li> -->
							
						</c:if>

						

					</c:if>

				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row J_mainContent" id="content-main">
				<iframe id="J_iframe" width="100%" height="100%"
					src="index_teacher_v1.jsp?v=4.0" frameborder="0" data-id="index_teacher_v1.jsp"
					seamless></iframe>
			</div>
		</div>
		<!--右侧部分结束-->
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/hAdmin.js?v=4.1.0"></script>
	<script type="text/javascript" src="js/index.js"></script>

	<!-- 第三方插件 -->
	<script src="js/plugins/pace/pace.min.js"></script>

</body>

</html>

