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
</head>
<body>
<c:forEach var="product" items="${sessionScope.cart}">
    <div>

        <h1><c:out value="${product.getName()}"/></h1>
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
<h1>Details</h1>
<h1><c:out value="${sessionScope.user.getfName()}" /></h1>
<h1><c:out value="${sessionScope.user.getlName()}" /></h1>
<h1><c:out value="${sessionScope.user.getPhoneNumber()}" /></h1>
<h1>Address</h1>
<c:choose>
    <c:when test="${sessionScope.addresses.size() > 0}">
        <form action="order" method="post">
            <%
                int index = 0;
            %>
            <c:forEach var="address" items="${sessionScope.addresses}">
                <label for="address${address.getId()}">Use this address: </label>
                <input id="address${address.getId()}" name="address<%=index%>" value="${address.getId()}" type="radio" />
                <p><c:out value="${address.getStreet()}" /></p>
                <p><c:out value="${address.getCity()}" /></p>
                <p><c:out value="${address.getProvinceState()}" /></p>
                <p><c:out value="${address.getPostalCode()}" /></p>
                <%
                    index++;
                %>
            </c:forEach>
            <button type="submit">Submit</button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="order" method="post">
            <label for="street">Street</label>
            <input id="street" name="street" type="text" />

            <label for="city">City</label>
            <input id="city" name="city" type="text" />

            <label for="province">Province/Territory/State</label>
            <input id="province" name="province" type="text" />

            <label for="postalCode">Postal Code</label>
            <input id="postalCode" name="postalCode" type="text" />

            <button type="submit">Submit</button>
        </form>
    </c:otherwise>

</c:choose>
</body>
</html>
