<%@page import="utils.StringUtil"%>
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
        <title>Edit Profile</title>
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
                        <h3 class="tile-title">Mission Detail</h3>
                        <div class="tile-body">
                            <div class="alert-danger">
                                <%= StringUtil.getString(request.getAttribute("error"))%>
                            </div>
                            <form class="form-horizontal" action="FrontController" method="POST">
                                <luannm:set var="missionDetail" value="${sessionScope.userMissionDetail}"/>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Mission Name</label>
                                    <div class="col-md-8">
                                        <input name="fullName" class="form-control col-md-8" type="text" placeholder="${missionDetail.myMission.mission_name}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Description</label>
                                    <div class="col-md-8">
                                        <input name="phone" class="form-control col-md-8" type="text" placeholder="${missionDetail.myMission.description}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Date Start</label>
                                    <div class="col-md-8">
                                        <input name="phone" class="form-control col-md-8" type="text" placeholder="${missionDetail.myMission.date_start}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Date End</label>
                                    <div class="col-md-8">
                                        <input name="phone" class="form-control col-md-8" type="text" placeholder="${missionDetail.myMission.date_end}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Your Robot</label>
                                    <div class="col-md-8">
                                        <input name="phone" class="form-control col-md-8" type="text" placeholder="${missionDetail.myRobot.robot_id} - ${missionDetail.myRobot.robot_name}" disabled>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Weapon</label>

                                    <div class="col-md-9">
                                        <luannm:forEach var="weap" items="${missionDetail.myRobot.listWeapon}">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input class="form-check-input" type="radio" name="weapon" value="${weap.weapon_id}">${weap.weapon_id} - ${weap.weapon_name}
                                                </label>
                                            </div>
                                        </luannm:forEach>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="control-label col-md-3">Members</label>
                                    <luannm:set var="listMember" value="${sessionScope.listOfMemberMission}" /> 
                                    <luannm:forEach var="mem" items="${listMember}">
                                        <div class="col-md-8">
                                            <input name="phone" class="form-control col-md-8" type="text" placeholder="${mem}" disabled>
                                        </div>
                                        <label class="control-label col-md-3"></label>
                                    </luannm:forEach>                                   
                                </div>
                                <div class="tile-footer">
                                    <luannm:if test="${missionDetail.myMission.date_end == ''}">
                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-3">
                                                <input name="username" type="text" value="${profile.userName}" hidden>
                                                <input name="missionId" type="text" value="${missionDetail.myMission.mission_id}" hidden>
                                                <button name="action" value="ChangeWeapon" class="btn btn-primary">Change Weapon to do mission</button>
                                            </div>
                                        </div>
                                    </luannm:if>
                                    <div class="row">
                                        <div class="col-md-8 col-md-offset-3">
                                            <a class="btn btn-secondary" href="FrontController?action=ViewMyMission"><i class="fa fa-arrow-left"></i>Back</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>


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