<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 21.11.2016
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">
    <div class="login-container">
        <div id="output"></div>
        <div class="avatar"></div>
        <div class="form-box">
            <c:if test="${not empty requestScope.message}">
                <div class="alert alert-danger">
                        ${message}
                </div>
            </c:if>
            <c:if test="${not empty requestScope.message1}">
                <div class="alert alert-success">
                        ${message1}
                </div>
            </c:if>
            <%--<form class="login-form" action="j_spring_security_check" method="post">--%>
                <%--<label for="j_username">Username: </label>--%>
                <%--<input id="j_username" name="j_username" size="20" maxlength="50" type="text" />--%>

                <%--<label for="j_password">Password: </label>--%>
                <%--<input id="j_password" name="j_password" size="20" maxlength="50" type="password" />--%>

                <%--<input type="submit" value="Login" />--%>
            <%--</form>--%>
            <form action="login" method="POST">
                <input name="login" type="text" placeholder="login">
                <input name="password" input type="password" placeholder="password">
                <button class="btn btn-info btn-block login" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>
