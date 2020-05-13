<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/13/2020
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/saveProverb" method="post" modelAttribute="proverbs">
    Author: <form:input path="author"/>
    <form:errors path="author"/>
    <br>
    Proverb: <form:textarea path="proverb"/>
    <form:errors path="proverb"/>
    <br>
    proverbDetail: <form:textarea path="proverbDetail"/>
    <form:errors path="proverbDetail"/>
    <br>
    <input type="submit" value="Submit">

</form:form>

</body>
</html>
