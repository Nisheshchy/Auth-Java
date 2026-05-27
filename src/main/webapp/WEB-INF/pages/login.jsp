<%--
  Created by IntelliJ IDEA.
  User: Sujan
  Date: 3/30/2026
  Time: 01:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String errormsg=(String) request.getAttribute("error");%>
<form method="post" action="login">
    <label >Email</label>
    <input name="email"/>
    <label >Password</label>
    <input name="password"/>
    <button type="submit">Login</button>
    <label>
        <%=errormsg%>
    </label>
</form>
</body>
</html>
