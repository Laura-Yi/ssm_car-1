<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
                        <li><a href="${basePath}/adminLogin/logout"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
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
                <li><a href="${basePath}/adminProject/show" class=""><i class="lnr lnr-chart-bars"></i> <span>查询教研/教材/教改项目</span></a></li>
                <li>
                    <a href="#schedule" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>排课</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="schedule" class="collapse ">
                        <ul class="nav">
                            <li><a href="${basePath}/adminSchedule/toPublicSchedule" class="">添加教学计划</a></li>
                        </ul>
                        <ul class="nav">
                            <li><a href="${basePath}/adminSchedule/showUnselected" class="">未排好的课程</a></li>
                        </ul>
                        <ul class="nav">
                            <li><a href="${basePath}/adminSchedule/toClass" class="">查看课程表</a></li>
                        </ul>
                        <ul class="nav">
                            <li><a href="${basePath}/adminSchedule/toBuildClass" class="">管理楼和教室</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- END LEFT SIDEBAR -->
</body>
</html>
