<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 01.12.2016
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="container">
    <div class="row text-center">
        <h3>Edit form</h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="widget-area no-padding blank">
                <div class="status-upload">
                    <form action="/edit_entry/${entry.id}" method="POST">
                        <textarea name="entry_out" type="text">${entry.entry}</textarea>
                        <button type="submit" class="btn btn-success green">Save</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
