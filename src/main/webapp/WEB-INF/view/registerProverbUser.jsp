<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/17/2020
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <form:form action="${pageContext.request.contextPath}/saveProverbUser" modelAttribute="proverbUser" method="POST">
                <div class="form-group">
                    <label>username:</label>
                    <form:input path="username" type="password" class="form-control"/>
                    <form:errors path="username"/>

                </div>
                <div class="form-group">
                    <label>password</label>
                    <form:input path="password" type="password" class="form-control"/>
                    <form:errors path="password"/>

                </div>
                <div class="form-group">
                    <label>first name:</label>
                    <form:input path="firstName" class="form-control"/>
                    <form:errors path="firstName"/>

                </div>
                <div class="form-group">
                    <label>last name:</label>
                    <form:input path="lastName" class="form-control"/>
                    <form:errors path="lastName"/>

                </div>
                <div class="form-group">
                    <label>email:</label>
                    <form:input path="email" type="email" class="form-control"/>
                    <form:errors path="email"/>

                </div>
                <div class="form-group">
                    <input type="submit" value="Submit" class="btn btn-info">

                </div>
            </form:form>


        </div>

    </div>

</div>

</body>
</html>
