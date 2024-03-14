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
    <title>Title</title>
</head>
<body>
<%--Add name of product --%>
<h1>Reviews for: </h1>
    <h1>Average rating: <c:out value="${sessionScope.averageRating}" /> </h1>

    <c:forEach var="review" items="${sessionScope.reviews}">
        <h1><c:out value="${review.getComment()}" /></h1>
        <h1><c:out value="${review.getScore()}" /></h1>
    </c:forEach>
</body>
</html>
