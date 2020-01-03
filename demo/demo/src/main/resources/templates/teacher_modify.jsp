<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> -教师注册信息修改</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>注册信息修改</h5>
                         
                    </div>
                    <div class="ibox-content">
                        <form   class="form-horizontal" method="post" action="/homework/admin/toModify">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">教师编号:</label>
								<div class="col-sm-3"> 
                                    <input type="text" class="form-control" name="user_count" required="required">
                                </div>
                            </div> <div class="form-group">
                                <label class="col-sm-2 control-label">教师姓名:</label>
								<div class="col-sm-3"> 
                                    <input type="text" class="form-control" name="name" required="required">
                                </div>
                            </div> <div class="form-group">
                                <label class="col-sm-2 control-label">注册密码:</label>
								<div class="col-sm-3"> 
                                    <input type="text" class="form-control" name="password" required="required">
                                </div>
                            </div> 
                            <div class="form-group">


                                <a href="admin_info_teacher.jsp">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-sm btn-primary" id="save" name="but" value="0">保存内容</button>
														<button type="button" class="btn btn-sm btn-primary" id="back" name="but" value="1">返回</button>
												</a> 
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div> 

    
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
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
    