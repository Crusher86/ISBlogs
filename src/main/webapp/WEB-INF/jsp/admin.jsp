<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 30.11.2016
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    User Lists

                    <div class="btn-group pull-right">
                        <h6>Total Count <span class="label label-info">${users.size()}</span></h6>
                    </div>
                </div>
                <c:forEach items="${users}" var="element">
                    <div class="panel-body_ad">
                        <ul class="list-group">
                            <li class="list-group-item">
                                ${element.login}
                            </li>
                        </ul>
                    </div>
                </c:forEach>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-md-6">
                            <h6>Total Count <span class="label label-info">${users.size()}</span></h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
