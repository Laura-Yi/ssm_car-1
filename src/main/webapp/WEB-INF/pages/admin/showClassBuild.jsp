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
    <jsp:include page="adminHeader.jsp"/>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">教室和楼</h3>
                <div class="row">
                    <div class="col-md-6">
                        <!-- BASIC TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">教室列表</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>教室</th>
                                        <th>楼</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${!empty classroomList}">
                                        <c:forEach items="${classroomList}" var="classroom">
                                            <tr>
                                                <td><input type="button" name="classDetail" value="${classroom.id}" ></td>
                                                <td>${classroom.name}</td>
                                                <td>${classroom.building}</td>
                                                <td><input type="button" name="doDelClass" id="${classroom.id}" value="删除" ></td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <tr>
                                        <form action="${basePath}/adminSchedule/addClassroom" method="post">
                                        <td><input type="text" name="name"></td>
                                        <td>
                                            <select name="building">
                                                <c:forEach items="${buildingList}" var="build">
                                                <option value="${build.name}" selected="selected">${build.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><input type="submit" value="添加教室"></td>
                                        </form>
                                    </tr>
                                    <tr>
                                        <form action="${basePath}/adminSchedule/addBuild" method="post">
                                            <td><input type="text" name="name"></td>
                                            <td><input type="submit" value="添加楼"></td>
                                        </form>
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
<script type="text/javascript">
    $("input[name='srtpDetail']").click(function () {
        var srtpId = this.value;
        window.location.href="${basePath}/adminSrtp/detail?srtpId="+srtpId;
    })

    $("input[name='doDel']").click(function () {
        var srtpId = this.id;
        window.location.href="${basePath}/adminSrtp/doDel?srtpId="+srtpId;
    })

</script>
</body>
</html>