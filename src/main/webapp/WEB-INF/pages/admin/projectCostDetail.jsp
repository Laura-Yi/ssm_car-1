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
                <h3 class="page-title">SRTP花费详情</h3>
                <div class="row">
                    <div class="col-md-6">
                        <!-- BASIC TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title"></h3>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th >课题：</th>
                                        <th>${projectmanager.projectname}</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>序号</th>
                                            <th>花费项目</th>
                                            <th>具体数目</th>
                                            <th>操作</th>
                                        </tr>
                                        <c:forEach items="${projectcostList}" var="projectCost" varStatus="item">
                                        <tr>
                                            <td>${item.count}</td>
                                            <td>${projectCost.detail}</td>
                                            <td>${projectCost.cost}</td>
                                            <td><input type="button" value="删除" name="delCost" id="${projectCost.id}"></td>
                                        </tr>
                                        </c:forEach>
                                        <tr>
                                            <td>project实际花费总额：</td>
                                            <td>${total}</td>
                                            <td>project预算花费:</td>
                                            <td>${projectmanager.buget}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form action="${basePath}/adminProject/addCost?projectId=${projectmanager.id}" method="post" >
                                                    <td>详情：<input type="text" name="detail"></td>
                                                    <td>花费：<input type="text" name="cost" value="0"></td>
                                                    <td><input type="submit" name="upload" value="添加花费项"/></td>
                                                </form>
                                            </td>
                                            <td></td>
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
$("input[name='cost']").mouseout(function(){
    var reg = /^[0-9]+$/ ;
    if (!reg.test(this.value)) {
        alert("请输入正整数");
    }
});

$("input[name='delCost']").click(function () {
    var projectCostId = this.id;
    window.location.href="${basePath}/adminProject/delProjectCost?projectId=${projectmanager.id}&projectCostId="+projectCostId;
})
</script>
</body>
</html>