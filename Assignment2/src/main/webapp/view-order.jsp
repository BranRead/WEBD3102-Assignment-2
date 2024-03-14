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
</head>
<body>
<c:forEach var="order" items="${sessionScope.orders}">
    <div>
        <h1><c:out value="${order.isShipped()}"/></h1>
        <h1><c:out value="${order.getTrackingNumber()}"/></h1>
        <h1><c:out value="${order.getStreet()}"/></h1>
        <h1><c:out value="${order.getCity()}"/></h1>
        <h1><c:out value="${order.getProvinceState()}"/></h1>
        <h1><c:out value="${order.getPostalCode()}"/></h1>
    </div>
</c:forEach>
</body>
</html>
