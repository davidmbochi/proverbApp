<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/17/2020
  Time: 7:40 PM
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
            <form action="${pageContext.request.contextPath}/authenticateTheUser" class="form-horizontal" method="post">
                <div class="input-group">
                    <input type="text" name="username" class="form-control" placeholder="username">

                </div>
                <div class="input-group">
                    <input type="password" name="password" class="form-control" placeholder="password">

                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Login</button>

                </div>

            </form>



        </div>

    </div>

</div>

</body>
</html>
