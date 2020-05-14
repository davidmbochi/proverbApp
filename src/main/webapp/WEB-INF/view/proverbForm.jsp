<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 5/13/2020
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
   <div class="container">
       <div class="row">
           <form:form action="saveProverb" modelAttribute="theproverb" method="POST">
               Author: <form:input path="author"/>

               <br>
               Proverb: <form:textarea path="proverb"/>

               <br>
               proverbDetail: <form:textarea path="proverbDetail"/>

               <br>
               <input type="submit" value="Submit">

           </form:form>

       </div>

   </div>

</body>
</html>
