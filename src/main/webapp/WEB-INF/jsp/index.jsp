<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    <%@include file='../../css/bootstrap.min.css' %>
    <%@include file='../../css/bootstrap-theme.min.css' %>
    <%@include file='../../css/main.css' %>
  </style>
  <title>${title}</title>
</head>
<body>
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/home">Blogs</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <c:choose>
          <c:when test="${empty pageContext.request.userPrincipal.name}">
            <li><a href="/login">Login</a></li>
            <li><a href="/registration">Register</a></li>
          </c:when >
          <c:otherwise>
            <li><a href="/profile">${pageContext.request.userPrincipal.name}</a></li>
            <li><a href="${logoutUrl}">Logout</a></li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>
</body>
<script> <%@include file='../../js/jquery-3.1.1.min.js' %> </script>
<script> <%@include file='../../js/bootstrap.min.js' %> </script>
</html>