<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<%--@elvariable id="product" type="lombok"--%>
<form:form action="edit" modelAttribute="product">

    <br>
    Title: <input type="text" name="title" value="${findProduct.title}" />
    <br>
    Price: <input type="text" name="price" value="${findProduct.price}" />
    <br>
    <input type="submit" value="EDIT">
</form:form>
</body>
</html>