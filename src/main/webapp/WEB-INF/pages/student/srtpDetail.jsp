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
    <jsp:include page="studentHeader.jsp"/>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">SRTP详情</h3>
                <div class="row">
                    <div class="col-md-6">
                        <!-- BASIC TABLE -->
                        <div class="panel">
                            <c:if test="${select eq 'selected'}">
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>课题：</th>
                                            <th>${srtpmanager.srtpname}</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>老师</td>
                                            <td>${teacher.name}</td>
                                        </tr>
                                        <tr>
                                            <td>学生</td><td>
                                            <c:forEach items="${studentList}" var="student">
                                                ${student.name} ;
                                            </c:forEach>
                                        </td>
                                        </tr>
                                        <tr>
                                            <td>srtp描述</td>
                                            <td>${srtpmanager.srtpdescription}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>SRTP状态</td>
                                            <td>${srtpmanager.status}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>申请表</td>
                                            <c:if test="${!empty srtpmanager.apllication}">
                                                <form action="${basePath}/teacherSrtp/downfile/SRTP申请表?srtpId=${srtpmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${srtpmanager.apllication}" ></td>
                                                </form>
                                            </c:if>
                                            <form action="${basePath}/teacherSrtp/uploadfile/SRTP申请表?srtpId=${srtpmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>中期检查表</td>
                                            <c:if test="${!empty srtpmanager.midcheck}">
                                                <form action="${basePath}/teacherSrtp/downfile/SRTP中期检查表?srtpId=${srtpmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${srtpmanager.midcheck}" ></td>
                                                </form>
                                            </c:if>
                                            <form action="${basePath}/teacherSrtp/uploadfile/SRTP中期检查表?srtpId=${srtpmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>SRTP结题验收表</td>
                                            <c:if test="${!empty srtpmanager.complete}">
                                                <form action="${basePath}/teacherSrtp/downfile/SRTP结题验收表?srtpId=${srtpmanager.id}" method="post">
                                                    <td><input type="submit" value="下载">  <input  type="hidden" name="filePath" value="${srtpmanager.complete}" ></td>
                                                </form>
                                            </c:if>
                                            <form action="${basePath}/teacherSrtp/uploadfile/SRTP结题验收表?srtpId=${srtpmanager.id}" method="post" enctype="multipart/form-data">
                                                <td><input type="file" name="file"/></td>
                                                <td><input type="submit" name="upload" value="上传"/></td>
                                            </form>
                                        </tr>
                                        <tr>
                                            <td>预算：${srtpmanager.cost}</td>
                                            <td>
                                                <form action="${basePath}/studentSrtp/addYuSuan?srtpId=${srtpmanager.id}" method="post" >
                                            <td><input type="text" name="YuSuan" value="0"/></td>
                                            <td><input type="submit" value="修改预算"/></td>
                                            </form>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><a href="${basePath}/studentSrtp/costDetail?srtpId=${srtpmanager.id}">实际花费细节</a></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </c:if>
                            <c:if test="${select eq 'unselected'}">
                                <div class="panel-heading">
                                    <h3 class="panel-title">还没有选择课题</h3>
                                </div>
                            </c:if>
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


    $("input[name='YuSuan']").mouseout(function(){
        var reg = /^[0-9]+$/ ;
        if (!reg.test(this.value)) {
            alert("请输入正整数");
        }
    });


</script>
</body>
</html>