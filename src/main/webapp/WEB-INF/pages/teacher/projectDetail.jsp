<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie ie6 lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="ie ie7 lt-ie9 lt-ie8"        lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="ie ie8 lt-ie9"               lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="ie ie9"                      lang="en"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-ie">
<!--<![endif]-->

<head>
    <base href="<%=basePath%>">
    <title>Tables | Klorofil - Free Bootstrap Dashboard Template</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="manager/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="manager/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="manager/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="manager/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="manager/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="manager/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="manager/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <jsp:include page="teacherHeader.jsp"/>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">项目管理</h3>
                <div class="row">
                    <div class="col-md-6">
                        <!-- BASIC TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">项目详情</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th >课题名称：</th>
                                        <th>${projectmanager.projectname}</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>项目描述</td>
                                            <td>${projectmanager.content}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>老师</td>
                                            <td>${teacher}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>项目类型</td>
                                            <td>${projectmanager.type}</td>
                                        </tr>
                                        <tr>
                                            <td>项目状态</td>
                                            <td>${projectmanager.status}</td>
                                        </tr>
                                        <tr>
                                            <td>评审结果</td>
                                            <form action="${basePath}/teacherProject/addreviewResult?projectId=${projectmanager.id}" method="post" >
                                                <td><input type="text" name="reviewResult" value="${projectmanager.reviewresult}"/></td>
                                                <td><input type="submit" value="填写"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>项目成果</td>
                                            <form action="${basePath}/teacherProject/addProjectresult?projectId=${projectmanager.id}" method="post" >
                                                <td><input type="text" name="projectresult" value="${projectmanager.projectresult}"/></td>
                                                <td><input type="submit" value="填写"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>项目预算</td>
                                            <form action="${basePath}/teacherProject/adduget?projectId=${projectmanager.id}" method="post" >
                                                <td><input type="text" name="buget" value="${projectmanager.buget}"/></td>
                                                <td><input type="submit" value="填写"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td><a href="${basePath}/teacherProject/costDetail?projectId=${projectmanager.id}">实际花费详情</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END BASIC TABLE -->
                    </div>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
            <p class="copyright">&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="manager/vendor/jquery/jquery.min.js"></script>
<script src="manager/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="manager/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="manager/scripts/klorofil-common.js"></script>
<script>
    $("input[name='buget']").mouseout(function(){
        var reg = /^[0-9]+$/ ;
        if (!reg.test(this.value)) {
            alert("请输入正整数");
        }
    });


</script>
</body>
</html>