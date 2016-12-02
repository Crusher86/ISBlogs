<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 21.11.2016
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/index.jsp"%>
<div class="container">
    <div class="login-container">
        <div id="output"></div>
        <div class="avatar"></div>
        <div class="form-box">
            <form action="login" method="POST">
                <input name="login" type="text" placeholder="login">
                <input name="password" input type="password" placeholder="password">
                <button class="btn btn-info btn-block login" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>
