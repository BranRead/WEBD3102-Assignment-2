<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Brandon
  Date: 3/12/2024
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordering</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid d-flex flex-row justify-content-between">
        <a class="navbar-brand ms-5" href="#">E-Commerce 's us</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse ms-3" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="main.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" href="order">View Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:choose><c:when test="${sessionScope.isLoggedIn != true}"><c:out value="disabled"/></c:when></c:choose>" href="view-cart.jsp">View Cart ()</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<div class="container bg-body-tertiary">
    <div class="row">
        <div class="offset-lg-4 col-lg-4">
            <h3 class="text-center">Items to be ordered: </h3>
            <c:forEach var="product" items="${sessionScope.cart}">
                <div>
                    <p>Product Name: <c:out value="${product.getName()}"/></p>
                    <p>Product Cost: $<c:out value="${product.getCost()}"/></p>
                    <p>Quantity: <c:out value="${product.getQuantityInCart()}"/></p>

                    <p>Total Cost: $<c:out value="${product.getCost() * product.getQuantityInCart()}"/></p>
                </div>
            </c:forEach>
            <p>Order Subtotal: $<c:out value="${sessionScope.totalCost}"/></p>
            <h3>Personal Info:</h3>
            <p><c:out value="${sessionScope.user.getfName()}" /></p>
            <p><c:out value="${sessionScope.user.getlName()}" /></p>
            <p><c:out value="${sessionScope.user.getPhoneNumber()}" /></p>
            <h3>Addresses on Account:</h3>
            <c:choose>
                <c:when test="${sessionScope.addresses.size() > 0}">
                    <form action="order" method="post">
                        <%
                            int index = 0;
                        %>
                        <c:forEach var="address" items="${sessionScope.addresses}">
                            <label for="address${address.getAddressId()}">Use this address: </label>
                            <input id="address${address.getAddressId()}" name="address<%=index%>" value="${address.getAddressId()}" type="radio" />
                            <p><c:out value="${address.getStreet()}" /></p>
                            <p><c:out value="${address.getCity()}" /></p>
                            <p><c:out value="${address.getProvinceState()}" /></p>
                            <p><c:out value="${address.getPostalCode()}" /></p>
                            <%
                                index++;
                            %>
                        </c:forEach>
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <h3>No address on file, please enter one below.</h3>
                    <form action="order" method="post">
                        <label for="street">Street</label>
                        <input id="street" name="street" type="text" />

                        <label for="city">City</label>
                        <input id="city" name="city" type="text" />

                        <label for="province">Province/Territory/State</label>
                        <input id="province" name="province" type="text" />

                        <label for="postalCode">Postal Code</label>
                        <input id="postalCode" name="postalCode" type="text" />

                        <button class="btn btn-primary" type="submit">Submit</button>
                    </form>
                </c:otherwise>

            </c:choose>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
