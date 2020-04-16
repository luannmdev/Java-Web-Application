<%@page import="model.Robot"%>
<!DOCTYPE html>
<%@page import="model.Profile"%>
<%@taglib prefix="luannm" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
        <!-- Twitter meta-->
        <meta property="twitter:card" content="summary_large_image">
        <meta property="twitter:site" content="@pratikborsadiya">
        <meta property="twitter:creator" content="@pratikborsadiya">
        <!-- Open Graph Meta-->
        <meta property="og:type" content="website">
        <meta property="og:site_name" content="Vali Admin">
        <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
        <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
        <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
        <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
        <title>Profile</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body class="app sidebar-mini rtl">
        <!-- Navbar-->
        <%@include file="/WEB-INF/top_nav.jspf"%>

        <main class="app-content">

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Profile</h3>
                        <div class="tile-body">
                            <form class="form-horizontal">

                                <div class="form-group row">
                                    <label class="control-label col-md-3">Full Name</label>
                                    <div class="col-md-8">
                                        <input name="fullName" class="form-control" type="text" placeholder="${profile.fullName}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Phone</label>
                                    <div class="col-md-8">
                                        <input name="phone" class="form-control col-md-8" type="text" placeholder="${profile.phone}"disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Birthday</label>
                                    <div class="col-md-8">
                                        <input name="birthday" class="form-control col-md-8" type="date" value="${profile.birthday}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Gender</label>

                                    <div class="col-md-9">
                                        <div class="">
                                            <input class="form-control col-md-8" type="text" placeholder="${profile.sex}" disabled>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="tile-footer">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-3">
                                    <a class="btn btn-primary" href="FrontController?action=ToEditProfile">Edit Profile</a>
                                </div>
                            </div>
                        </div>
                        <div class="tile-footer">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-3">
                                    <a class="btn btn-primary" href="FrontController?action=ToEditPassword">Change Password</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <luannm:set var="robot" value="${sessionScope.robot}"/>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Your Robot</h3>

                        <div class="tile-body">
                            <luannm:choose>
                                <luannm:when test="${profile.robot_id == ''}">
                                    <h4>You have no Robot</h4>                        
                                </luannm:when>
                                <luannm:when test="${profile.robot_id == null}">
                                    <h4>You have no Robot</h4>                        
                                </luannm:when>       
                                <luannm:otherwise>
                                    <form class="form-horizontal">
                                        <div class="form-group row">
                                            <label class="control-label col-md-3">Robot Name</label>
                                            <div class="col-md-8">
                                                <input name="robotName" class="form-control col-md-8" type="text" placeholder="${robot.robot_name}" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="control-label col-md-3">Decription</label>
                                            <div class="col-md-8">
                                                <input name="description" class="form-control col-md-8" type="text" placeholder="${robot.description}"disabled>
                                            </div>
                                        </div>                              
                                    </form>
                                </luannm:otherwise>
                            </luannm:choose>
                        </div>
                        <luannm:choose>
                            <luannm:when test="${sessionScope.weaponlist == null}">
                                <h4>The robot have no weapon</h4> 
                            </luannm:when>
                            <luannm:when test="${sessionScope.weaponlist.size() == 0}">
                                <h4>The robot have no weapon</h4> 
                            </luannm:when>
                            <luannm:otherwise>
                                <luannm:set var="list" value="${sessionScope.weaponlist}" /> 

                                <luannm:forEach var="wea" items="${list}">
                                    <div class="tile-footer">
                                        <form class="form-horizontal">
                                            <div class="form-group row">
                                                <label class="control-label col-md-3">Weapon ${wea.weapon_id}</label>
                                                <div class="col-md-8">
                                                    <input name="robotName" class="form-control col-md-8" type="text" placeholder="${wea.weapon_name}" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="control-label col-md-3">Decription</label>
                                                <div class="col-md-8">
                                                    <input name="robotName" class="form-control col-md-8" type="text" placeholder="${wea.description}" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="control-label col-md-3">Decription</label>
                                                <div class="col-md-8">
                                                    <input name="robotName" class="form-control col-md-8" type="text" placeholder="${wea.type}" disabled>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </luannm:forEach>
                            </luannm:otherwise>
                        </luannm:choose>


                    </div>
                </div>
            </div>
        </main>
        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <!-- Google analytics script-->
        <script type="text/javascript">
            if (document.location.hostname == 'pratikborsadiya.in') {
                (function (i, s, o, g, r, a, m) {
                    i['GoogleAnalyticsObject'] = r;
                    i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                    a = s.createElement(o),
                            m = s.getElementsByTagName(o)[0];
                    a.async = 1;
                    a.src = g;
                    m.parentNode.insertBefore(a, m)
                })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
                ga('create', 'UA-72504830-1', 'auto');
                ga('send', 'pageview');
            }
        </script>
    </body>
</html>