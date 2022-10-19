<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP</title>
</head>
<body>
<h1>APP:</h1>
<%--@elvariable id="findProduct" type="ru.gb.entity.Product"--%>

<form:form action="search" modelAttribute="findProduct">
    Find: <form:input path="id" />
    <input type="submit" value="Search">
</form:form>
<br>
<c:url var="productListUrl" value="/product/all"/>
<a href="${productListUrl}">CATALOG</a>
<br>
<br>
<c:url var="createUrl" value="/product/create"/>
<a href="${createUrl}">ADD</a>
<br>
</body>
</html>