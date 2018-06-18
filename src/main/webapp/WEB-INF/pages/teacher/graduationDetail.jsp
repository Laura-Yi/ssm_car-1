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
                                            <c:choose>
                                                <c:when test="${graduationmanager.bookassign eq null}">
                                                    <form action="${basePath}/teacherGraduate/uploadfile/任务书?graduationId=${graduationmanager.id}" method="post" enctype="multipart/form-data">
                                                        <td><input type="file" name="file"/></td>
                                                        <td><input type="submit" name="upload" value="上传"/></td>
                                                    </form>
                                                </c:when>
                                                <c:otherwise>
                                            <td>
                                                <form action="${basePath}/teacherGraduate/downfile/任务书?graduationId=${graduationmanager.id}" method="post">
                                                    <input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.bookassign}" >
                                                </form>
                                            </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                        <tr>
                                            <td>选题报告</td>
                                            <c:if test="${!empty graduationmanager.topicselectionreport}">
                                                <form action="${basePath}/teacherGraduate/downfile/选题报告?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.topicselectionreport}" ></td>
                                                </form>
                                            </c:if>
                                            <form action="${basePath}/teacherGraduate/uploadfile/选题报告?graduationId=${graduationmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
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
                                            <form action="${basePath}/teacherGraduate/uploadfile/评阅表?graduationId=${graduationmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>评阅意见表</td>
                                            <c:if test="${!empty graduationmanager.revieweropinionform}">
                                                <form action="${basePath}/teacherGraduate/downfile/评阅意见表?graduationId=${graduationmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${graduationmanager.revieweropinionform}" ></td>
                                                </form>
                                            </c:if>
                                            <form action="${basePath}/teacherGraduate/uploadfile/评阅意见表?graduationId=${graduationmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
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