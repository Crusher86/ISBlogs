<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 21.11.2016
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div class="login-container">
        <div id="output"></div>
        <div class="avatar"></div>
        <div class="form-box">
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                        ${error}
                </div>
            </c:if>
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>
            <form action="j_spring_security_check" method="POST">
                <input name="username" type="text" placeholder="username">
                <input name="password" input type="password" placeholder="password">
                <button class="btn btn-info btn-block login" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>
