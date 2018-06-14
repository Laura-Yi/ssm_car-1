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
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index.html"><img src="manager/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="manager/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                    <!-- <li>
                        <a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
                    </li> -->
                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li>
                        <a href="#graduation" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>毕业论文</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="graduation" class="collapse ">
                            <ul class="nav">
                                <li><a href="${basePath}/adminGraduate/show" class="">查询所有课题</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="${basePath}/adminSrtp/show" class=""><i class="lnr lnr-code"></i> <span>查询所有SRTP</span></a></li>
                    <li><a href="charts.html" class=""><i class="lnr lnr-chart-bars"></i> <span>Charts</span></a></li>
                    <li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>Panels</span></a></li>
                    <li><a href="notifications.html" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>
                    <li>
                        <a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subPages" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">Profile</a></li>
                                <li><a href="page-login.html" class="">Login</a></li>
                                <li><a href="page-lockscreen.html" class="">Lockscreen</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="tables.html" class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>
                    <li><a href="typography.html" class=""><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
                    <li><a href="icons.html" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">发布毕业论文课题</h3>
                <div class="row">
                    <div class="col-md-6">
                        <!-- BASIC TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">论文列表</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th style="width:100px;">课题：</th>
                                        <th>${graduationmanager.topic}</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>老师</td>
                                            <td>${teacher}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>学生</td>
                                            <td>${student}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>描述</td>
                                            <td>${graduationmanager.description}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>任务书</td>
                                            <c:if test="${!empty graduationmanager.bookassign}">
                                                <form action="${basePath}/teacherGraduate/downfile/任务书?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.bookassign}" ></td>
                                                </form>
                                            </c:if>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>选题报告</td>
                                            <c:if test="${!empty graduationmanager.topicselectionreport}">
                                                <form action="${basePath}/teacherGraduate/downfile/选题报告?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.topicselectionreport}" ></td>
                                                </form>
                                            </c:if>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>中期考核表</td>
                                            <c:if test="${!empty graduationmanager.midcheck}">
                                                <form action="${basePath}/teacherGraduate/downfile/中期考核表?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.midcheck}" ></td>
                                                </form>
                                            </c:if>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>毕业论文</td>
                                            <c:if test="${!empty graduationmanager.graduationstudy}">
                                                <form action="${basePath}/teacherGraduate/downfile/毕业论文?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.graduationstudy}" ></td>
                                                </form>
                                            </c:if>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>评阅表</td>
                                            <c:if test="${!empty graduationmanager.reviewform}">
                                                <form action="${basePath}/teacherGraduate/downfile/评阅表?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.reviewform}" ></td>
                                                </form>
                                            </c:if>
                                        </tr>
                                        <tr>
                                            <td>评阅意见表</td>
                                            <c:if test="${!empty graduationmanager.revieweropinionform}">
                                                <form action="${basePath}/teacherGraduate/downfile/评阅意见表?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.revieweropinionform}" ></td>
                                                </form>
                                            </c:if>
                                        </tr>
                                        <tr>
                                            <td>评审结果</td>
                                            <c:choose>
                                                <c:when test="${empty graduationmanager.resultform}">
                                                    <form action="${basePath}/teacherGraduate/result?graduationId=${graduationmanager.id}" method="post" >
                                                        <td><input type="text" name="resultform"/></td>
                                                        <td><input type="submit"  value="提交评审结果"/></td>
                                                        <td></td>
                                                    </form>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${graduationmanager.resultform}</td>
                                                    <td></td>
                                                    <td></td>
                                                </c:otherwise>
                                            </c:choose>
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
    $("input[name='doDel']").click(function () {
        var graduationId = this.value;
        jQuery.ajax({
            url: 'localhost/student/doDel.action',
            data: { "studentId": studentId },
            dataType: "json",
            type: "POST"
        });
        window.localtion.reload();
    })


</script>
</body>
</html>