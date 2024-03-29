<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/14/2020
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/proverbApp.css">
</head>
<body style="background-color: wheat">
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <a href="${pageContext.request.contextPath}/proverbForm" class="btn btn-success" style="margin-top: 10px">ADD PROVERB</a>
        </div>
        <div class="col-md-6" >
            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="btn btn-success">LOGOUT</button>

            </form:form>
        </div>
     </div>

    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>Author</th>
                        <th>proverb</th>
                        <th>proverb meaning</th>
                        <th>up Vote</th>
                        <th>down Vote</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="tempProverb" items="${theproverbs}">
                    <C:url var="updateLink" value="/updateProverb">
                        <c:param name="proverbId" value="${tempProverb.id}"></c:param>

                    </C:url>
                    <c:url var="deleteLink" value="/deleteProverb">
                        <c:param name="proverbId" value="${tempProverb.id}"></c:param>

                    </c:url>
                    <tr>
                        <td>${tempProverb.author}</td>
                        <td>${tempProverb.proverb}</td>
                        <td>${tempProverb.proverbDetail}</td>
                        <td>
                            <a class="btn btn-info">${tempProverb.upVote}</a>
                        </td>
                        <td>
                            <a class="btn btn-info">${tempProverb.downVote}</a>
                        </td>
                        <td>
                            <a href="${updateLink}" class="btn btn-info">Update</a>
                        </td>
                        <td>
                            <a href="${deleteLink}" class="btn btn-danger" onclick="if(!(confirm('Are you sure'))) return false">Delete</a>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>


            </table>

        </div>

    </div>


</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
