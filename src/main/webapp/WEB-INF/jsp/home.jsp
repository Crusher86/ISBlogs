<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 20.11.2016
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">
    <c:if test="${not empty sessionScope.id}">
        <c:forEach items="${blogs}" var="element">
            <a href="/diary/${element.id}">${element.title}</a></br>
        </c:forEach>
    </c:if>
</div>



