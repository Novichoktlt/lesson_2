<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List:</h1>
<%--@elvariable id="findProduct" type="ru.gb.entity.Product"--%>
<form:form action="search" modelAttribute="findProduct">
    Find: <form:input path="id" />
    <input type="submit" value="Search">
</form:form>
<c:url var="maxUrl" value="/product/all?sort=max"/>
<c:url var="mixUrl" value="/product/all?sort=mix"/>
<a href="${maxUrl}">MAX</a> <a href="${mixUrl}">MIX</a>
<form:form action="show" modelAttribute="findProduct" >
    with: <input type="text" name="min" value="0" />
    to: <input type="text" name="max" value="0" />
    <input type="submit" value="show">
</form:form>

<ul>
    <c:forEach var="product" items="${products}">
        <c:url var="editUrl" value="/product/${product.id}"/>
        <c:url var="deleteUrl" value="/product/${product.id}?delete=true"/>
        <li>
            ID: ${product.id}
            Title: ${product.title}
            Price: ${product.price}
            <a href="${editUrl}">EDIT</a>
            <a href="${deleteUrl}">DELETE</a>
        </li>
    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/product/create"/>

<a href="${createUrl}">ADD</a>
<br>
</body>
</html>