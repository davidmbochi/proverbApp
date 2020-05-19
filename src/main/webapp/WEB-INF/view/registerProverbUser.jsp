<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/17/2020
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/proverbApp.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <form:form action="${pageContext.request.contextPath}/saveProverbUser" modelAttribute="proverbUser" method="POST" class="form-horizontal bg-info">
                <div class="form-group">
                    <div class="col-xm-15">
                        <div>
                            <c:if test="${registrationError != null}">
                                <div class="alert alert-danger">
                                    ${registrationError}


                                </div>
                            </c:if>
                        </div>
                        

                    </div>

                </div>
                <div class="input-group" style="margin-bottom: 25px">
                    <form:input path="username"  class="form-control" placeholder="username"/>
                    <form:errors path="username"/>

                </div>
                <div class="input-group" style="margin-bottom: 25px">
                    <form:input path="password" type="password" class="form-control" placeholder="password"/>
                    <form:errors path="password"/>

                </div>
                <div class="input-group" style="margin-bottom: 25px">
                    <form:input path="firstName" class="form-control" placeholder="firstName"/>
                    <form:errors path="firstName"/>

                </div>
                <div class="input-group" style="margin-bottom: 25px">
                    <form:input path="lastName" class="form-control" placeholder="lastName"/>
                    <form:errors path="lastName"/>

                </div>
                <div class="input-group" style="margin-bottom: 25px">
                    <form:input path="email" type="email" class="form-control" placeholder="email"/>
                    <form:errors path="email"/>

                </div>
                <div class="form-group" style="margin-top: 10px; text-align: center">
                    <button type="submit" class="btn btn-success">SUBMIT</button>

                </div>
            </form:form>


        </div>

    </div>

</div>

</body>
</html>
