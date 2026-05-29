<%--
  Created by IntelliJ IDEA.
  User: Sujan
  Date: 3/20/2026
  Time: 03:15label>
        <input name="name"/>
        <label>Email PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<% String errormsg=(String)request.getAttribute("error");%>
<form method="post" action="register">
  <label>Name</label>
  <input name="name"/>
  <label>Email</label>
  <input name="email"/>
  <label>Password</label>
  <input name="password"/>
  <button type="submit">Register</button>
  <label>
    <%=errormsg%>
  </label>
</form>
</body>
</html>
