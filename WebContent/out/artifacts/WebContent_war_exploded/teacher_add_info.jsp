<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 录入比赛信息</title>
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
                        <h5> &nbsp; &nbsp; &nbsp;录入比赛信息</h5>
                         
                    </div>
                    <div class="ibox-content">
                        <form   class="form-horizontal" method="post" action="UserInfoServlet?opr=courseadd">
                              <div class="form-group">
                                <label class="col-sm-2 control-label">比赛名称:</label>
								<div class="col-sm-3"> 
                                    <input type="text" class="form-control" name="course_name" >
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-7 control-label">比赛类型:&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="teacher1"  name="xxx"/>A类   &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="student2" name="xxx"/>B类&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="student3" name="xxx"/>C类&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                         其它  &nbsp; &nbsp;<input type="text" id="student4" name="xxx"/>
                               
                                </label>

                                
                            </div>
                            
                             <div class="form-group">
                                <label class="col-sm-8 control-label">比赛等级:&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="student5"  name="1xxx"/>一等奖   &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="student6" name="1xxx"/>二等奖&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" id="student7" name="1xxx"/>三等奖&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                         其它  &nbsp; &nbsp;<input type="text" id="student8" name="1xxx"/>
                               
                                </label>

                                
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                             <div class="form-group">
                                <label class="col-sm-2 control-label">指导教师:</label>
								<div class="col-sm-2"> 
                                    <input type="text" class="form-control" name="course_name" >
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">参赛学生:</label>
								<div class="col-sm-2"> 
                                    <input type="text" class="form-control" name="course_name" >
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">班级:</label>
								<div class="col-sm-2"> 
                                    <input type="text" class="form-control" name="course_name" >
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">学号:</label>
								<div class="col-sm-2"> 
                                    <input type="text" class="form-control" name="course_name" >
                                </div>
                            </div> 
                            <div class="form-group">
                                <label class="col-sm-2 control-label">竞赛证书:</label>
								<div class="col-sm-3"> 
                                    <input type="file" multiple id="imgLocal" accept="image/*"  />
                                </div>
                            </div> 
                              <div class="form-group">
                                <label class="col-sm-2 control-label">指导证书:</label>
								<div class="col-sm-3"> 
                                    <input type="file" multiple id="imgLocal" accept="image/*"  />
                                </div>
                            </div>   <div class="form-group">
                                <label class="col-sm-2 control-label">比赛照片:</label>
								<div class="col-sm-3"> 
                                    <input type="file" multiple id="imgLocal" accept="image/*"  />
                                </div>
                            </div> 
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-1 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button> 
                                    
                                </div>
                                
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
    