<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Brandon
  Date: 3/1/2024
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">E-Commerce 's us</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="main.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">View Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view-cart.jsp">View Cart ()</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Login
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="d-flex flex-column" action="login" method="POST">
                    <label for="username">Username</label>
                    <input class="form-control" id="username" type="text" name="username"/>

                    <label for="password">Password</label>
                    <input class="form-control" id="password" type="password" name="password"/>

                    <button class="btn btn-primary my-2" type="submit">Login</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${sessionScope.isLoggedIn != true}">
        <h1>Please log in to add items to your cart and complete orders</h1>
    </c:when>
</c:choose>
<c:forEach var="product" items="${sessionScope.products}">
    <div>
        <h1><c:out value="${product.getName()}"/></h1>
        <h1><c:out value="${product.getDescription()}"/></h1>
        <h1><c:out value="${product.getStock()}"/></h1>
        <h1><c:out value="${product.getCost()}"/></h1>
        <form action="index.jsp" method="post"><button type="submit" name="id" value="<c:out value="${product.getId()}"/>">Reviews</button></form>
        <c:choose>
            <c:when test="${sessionScope.isLoggedIn == true}">
                <form action="cart" method="post">
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" min="1">
                    <button type="submit" name="productId" value="<c:out value="${product.getId()}"/>">Add to Cart</button>
                </form>
            </c:when>
        </c:choose>

    </div>
</c:forEach>
<c:choose>
    <c:when test="${requestScope.quantity != null}">
        <h1><c:out value="${requestScope.id}"/></h1>
        <h1><c:out value="${requestScope.productId}"/></h1>
        <h1><c:out value="${requestScope.quantity}"/></h1>
    </c:when>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
