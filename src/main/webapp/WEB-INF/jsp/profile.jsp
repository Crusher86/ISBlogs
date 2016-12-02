<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 20.11.2016
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${user.getFirstName()} ${user.getLastName()}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://streamerz.net/wp-content/uploads/2014/02/Streamerz-Team-Avatar-v1-mo5-300x300.png" class="img-circle img-responsive"> </div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Profession</td>
                                    <td>${user.getProfession()}</td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td>${user.getDate_birth()}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>Gender</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.getGender() == '2'}">
                                                Male
                                                <br />
                                            </c:when>
                                            <c:when test="${user.getGender() == '3'}">
                                                Female
                                                <br />
                                            </c:when>
                                            <c:otherwise>

                                                <br />
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Home Address</td>
                                    <td>${user.getAddress()}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${user.getEmail()}</td>
                                </tr>
                                <td>Phone Number</td>
                                <td>${user.getPhone()}</td>

                                </tr>

                                </tbody>
                            </table>

                            <%--<a href="#" class="btn btn-primary">My Sales Performance</a>--%>
                            <a href="/home" class="btn btn-primary pull-right">My personal blogs</a>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <%--<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>--%>
                    <span>
                            <a href="/edit" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning">Edit</a>
                            <%--<a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>--%>
                    </span>
                </div>

            </div>
        </div>

</div>
