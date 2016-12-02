<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 30.11.2016
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">

        <c:forEach items="${entries}" var="element">

            <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-3">
                                <h4 class="pull-left">
                                    <small><em>${element.date}</em></small>
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel-body">
                        ${element.entry}
                </div>

                <div class="panel-footer">

                    <span>
                            <a href="/new_entry/${element.blog_id}" data-original-title="Edit this entry" data-toggle="tooltip" type="button" class="btn btn-sm btn-success">New</a>
                            <a href="/edit_entry/${element.id}" data-original-title="Edit this entry" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning">Edit</a>
                            <a href="/delete/${element.blog_id}/${element.id}"data-original-title="Remove this entry" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger">Delete</a>
                    </span>
                </div>
            </div>
        </c:forEach>
</div>
