<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Brandon
  Date: 3/11/2024
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reviews</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid d-flex flex-row justify-content-between">
        <a class="navbar-brand ms-5" href="#">E-Commerce 's us</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse ms-3" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="main.jsp">Home</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" href="order">View Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" href="view-cart.jsp">View Cart ()</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<%
    int numOfReview = 1;
%>
<div class="container">
    <div class="row">
        <h3 class="text-center text-white">Reviews for: <c:out value="${sessionScope.product.getName()}" /></h3>
        <h4 class="text-center text-white">Average rating: <c:out value="${sessionScope.averageRating}" /> </h4>

        <c:forEach var="review" items="${sessionScope.reviews}">
            <div class="offset-lg-4 col-lg-4 bg-light my-2">
                <p>Review #<%=numOfReview%></p>
                <p>Review: <c:out value="${review.getComment()}" /></p>
                <p>Score: <c:out value="${review.getScore()}"/>/5</p>
            </div>
            <%
                numOfReview++;
            %>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
