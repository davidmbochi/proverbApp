<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/13/2020
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
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
               <p>POST A POPULAR PROVERB THAT YOU KNOW</p>
               <form:form action="saveProverb" modelAttribute="theproverb" method="POST" class="bg-info">

                   <form:hidden path="id"></form:hidden>
                   <div class="form-group" style="margin-bottom: 25px">
                       <form:input path="author" class="form-control" placeholder="author"/>
                       <form:errors path="author"></form:errors>

                   </div>

                   <br>
                   <div class="form-group" style="margin-bottom: 25px">
                       <form:textarea path="proverb" class="form-control" placeholder="proverb"/>
                       <form:errors path="proverb"></form:errors>

                   </div>


                   <br>
                   <div class="form-group" style="margin-bottom: 25px">
                       <form:textarea path="proverbDetail" class="form-control" placeholder="proverb meaning"/>
                       <form:errors path="proverbDetail"></form:errors>
                   </div>


                   <br>
                   <div class="form-group" style="margin-top: 10px; text-align: center">
                       <button type="submit" class="btn btn-success">SUBMIT</button>

                   </div>


               </form:form>
               <a href="${pageContext.request.contextPath}/" class="btn btn-primary">VIEW PROVERBS</a>
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
