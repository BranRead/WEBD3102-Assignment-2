<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Brandon
  Date: 3/13/2024
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Orders</title>
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
                    <a class="nav-link active <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" aria-current="page"   href="order">View Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" href="view-cart.jsp">View Cart ()</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<c:choose>
    <c:when test="${sessionScope.orders == null || sessionScope.orders == ''}" >
        <h3 class="text-center text-white">No orders found. Order something today!</h3>
    </c:when>
</c:choose>
<div>
    <div>
        <c:forEach var="order" items="${sessionScope.orders}">
            <h3 class="text-center text-white">Order ID: ${order.getId()}</h3>
            <div class="offset-lg-4 col-lg-4 bg-light">
                <c:choose>
                    <c:when test="${order.isShipped() == true}">
                        <p>Shipped</p>
                    </c:when>
                    <c:otherwise>
                        <p>Not yet shipped</p>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${order.getTrackingNumber() != null}">
                        <p>Tracking Number: <c:out value="${order.getTrackingNumber()}"/></p>
                    </c:when>
                    <c:otherwise>
                        <p>Tracking Number: Not yet provided</p>
                    </c:otherwise>
                </c:choose>

                <h4>Address shipped to:</h4>
                <p><c:out value="${order.getStreet()}"/></p>
                <p><c:out value="${order.getCity()}"/></p>
                <p><c:out value="${order.getProvinceState()}"/></p>
                <p><c:out value="${order.getPostalCode()}"/></p>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
