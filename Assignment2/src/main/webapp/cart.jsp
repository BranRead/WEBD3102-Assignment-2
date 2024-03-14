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
        <h1><c:out value="${product.getName()}"/></h1>
        <h1><c:out value="${product.getCost()}"/></h1>
        <h1><c:out value="${product.getQuantityInCart()}"/></h1>
    </div>
</c:forEach>
<h1>Total cost: <c:out value="${requestScope.totalCost}" /></h1>
<button type="button"><a href="address">Order!</a></button>
</body>
</html>
