<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Brandon
  Date: 3/12/2024
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<c:forEach var="product" items="${sessionScope.cart}">
    <div>

        <h1 name="name"><c:out value="${product.getName()}"/></h1>




<%--        <h1><c:out value="${product.getDescription()}"/></h1>--%>
<%--        <h1><c:out value="${product.getStock()}"/></h1>--%>
<%--        <h1><c:out value="${product.getCost()}"/></h1>--%>
<%--        <form action="index.jsp" method="post"><button type="submit" name="id" value="<c:out value="${product.getId()}"/>">Reviews</button></form>--%>
<%--        <c:choose>--%>
<%--            <c:when test="${sessionScope.isLoggedIn == true}">--%>
<%--                <form action="cart" method="post">--%>
<%--                    <label for="quantity">Quantity:</label>--%>
<%--                    <input type="number" id="quantity" name="quantity" min="1">--%>
<%--                    <button type="submit" name="productId" value="<c:out value="${product.getId()}"/>">Add to Cart</button>--%>
<%--                </form>--%>
<%--            </c:when>--%>
<%--        </c:choose>--%>
    </div>
</c:forEach>
<button type="button"><a href="address">Order!</a></button>
</body>
</html>
