<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 20.11.2016
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/index.jsp"%>
<div class="container">
    <%
        if ((session.getAttribute("login") == null) || (session.getAttribute("login") == "")) {
    %>
    You are not logged in<br/>
    <a href="index.jsp">Please Login</a>
    <%} else {
    %>
    Welcome <a href = profile.jsp><%=session.getAttribute("login")%></a>
    <h1>Personal blogs</h1>
    <%
        }
    %>
</div>



