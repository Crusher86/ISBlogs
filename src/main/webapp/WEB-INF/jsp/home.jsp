<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 20.11.2016
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div>
    <a class="navbar-brand" data-toggle="modal" data-target="#myModal">New</a>
    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Заголовок модального окна -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Create new blog</h4>
                </div>
                <!-- Основное содержимое модального окна -->
                <div class="modal-body">

                </div>
                <!-- Футер модального окна -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save change</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#myModalBox").modal('show');
        });
    </script>
    <div class="container">
        <c:if test="${not empty sessionScope.id}">
            <c:forEach items="${blogs}" var="element">
                <a href="/diary/${element.id}">${element.title}</a></br>
            </c:forEach>
        </c:if>
    </div>
</div>




