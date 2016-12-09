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
                    <form:form method="POST" action="registration" modelAttribute="userModel">
                        <div hidden>
                            <form:label path="id">ID</form:label>
                            <form:input path="id" readonly="true"/>
                        </div>
                        <div hidden>
                            <form:label path="version">Version</form:label>
                            <form:input path="version" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <form:input type="text" path="username" class="form-control input-sm floatlabel" placeholder="Login" />
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <form:input type="password" path="password" class="form-control input-sm" placeholder="Password" />
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <form:input type="password" path="confPassword" class="form-control input-sm" placeholder="Confirm Password" />
                                </div>
                            </div>
                        </div>
                    <%--</form:form>--%>
                    <%--<form:form method="POST" action="registration" modelAttribute="profile">--%>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <%--<form:input type="text" path="firstName" class="form-control input-sm floatlabel" placeholder="First Name" />--%>
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



                        <input type="submit" value="Register" class="btn btn-info btn-block">

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
