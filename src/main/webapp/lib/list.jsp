<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 5/16/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CUSTOMER LIST</h1>
<a href="customers?router=create">Create</a>
<form action="customers" >
    <input type="text" name="name">
    <button>Search</button>
</form>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>address</th>
        <th colspan="2">ACTIVE</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="/customers?router=edit&&id=${customer.id}">edit</a></td>
            <td><a href="/customers?router=delete&&id=${customer.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
