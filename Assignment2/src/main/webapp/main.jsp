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
</head>
<body>
<c:forEach var="product" items="${sessionScope.products}">
    <div>
        <h1><c:out value="${product.getName()}"/></h1>
        <h1><c:out value="${product.getDescription()}"/></h1>
        <h1><c:out value="${product.getStock()}"/></h1>
        <h1><c:out value="${product.getCost()}"/></h1>
        <form action="index.jsp" method="post"><button type="submit" name="id" value="<c:out value="${product.getId()}"/>">Reviews</button></form>
    </div>
</c:forEach>
</body>
</html>
