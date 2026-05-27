<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="register">Register</a>
<br/>
<a href="login">Login</a>

<%--//JSTL Java Server pages Standard Tag Library--%>
<%--//JSP Standard Tag Library--%>
<%--//JSP Java Server Pages--%>

<%
    int i=0;
%>
<%
    if(i>0){
%>
<h1> Value of i is +ve</h1>
<%
    }else if(i<0){
%>
<h1>Value of i is -ve</h1>
<%
    }else{
%>
<h1>Value of i is zero</h1>
<%
    }
%>

<c:set var="x" value="0" scope="application"/>
<c:if test="${x>0}">
    <h1>X is positive</h1>
</c:if>

<c:choose>
    <c:when test="${x>0}">
        <h1>X is positive</h1>
    </c:when>
    <c:when test="${x<0}">
        <h1>X is negative</h1>
    </c:when>
</c:choose>


<%--<%--%>
<%--    com.authentication.user.model.UserModel user=(com.authentication.user.model.UserModel)session.getAttribute("user");--%>
<%--%>--%>
<%--<%--%>
<%--    if(user!=null){--%>
<%--%>--%>
<%--<h1>Name: ${user.getName()}</h1>--%>
<%--<%--%>
<%--    }else{--%>
<%--%>--%>
<%--<h1>Please log in</h1>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>

<c:choose>
    <c:when test="${not empty user}">
        <h1>Name: ${user.getName()}</h1>
    </c:when>
    <c:otherwise>
        <h1>Please log in</h1>
    </c:otherwise>
</c:choose>


</body>
</html>