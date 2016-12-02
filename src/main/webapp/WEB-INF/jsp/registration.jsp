<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 19.11.2016
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Registration in system <small>It's free!</small></h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty requestScope.message}">
                        <div class="alert alert-danger">
                                ${message}
                        </div>
                    </c:if>
                    <form action="registration" method="POST">
                        <div class="form-group">
                            <input type="text" name="login" id="login" class="form-control input-sm floatlabel" placeholder="Login">
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name" class="form-control input-sm floatlabel" placeholder="First Name">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="conf_password" id="conf_password" class="form-control input-sm" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>

                        <input type="submit" value="Register" class="btn btn-info btn-block">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
