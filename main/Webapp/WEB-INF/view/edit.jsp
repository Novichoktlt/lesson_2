<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<form:form action="edit" modelAttribute="product">
    <br>
    Title: <form:input path="title"/>
    <br>
    Price: <form:input path="price"/>
    <br>
    <input type="submit" value="EDIT">
</form:form>
</body>
</html>