<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 14/09/2023
  Time: 1:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <style>
        table, tr, th, td {
            border: 1px solid;
            border-collapse: collapse;
        }
        caption{
            font-weight: bold;
        }
        td{
            padding: 3px 20px;
        }
        th{
            background: gray;
        }
        tbody tr:hover {
            background: gainsboro;
        }
    </style>
</head>
<body>
<p>There are 5 customers in list</p>
<table>
    <caption>CustomerList</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
