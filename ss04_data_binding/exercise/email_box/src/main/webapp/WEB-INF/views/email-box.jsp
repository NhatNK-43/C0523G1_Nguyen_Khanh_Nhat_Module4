<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Email</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        table,th,td,tr{
            border: 1px solid gray;
            border-collapse: collapse;
        }
        thead {
            background: gray;
        }
        tbody{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Email update</h1>
<p class="text-success">${mess}</p>
<table>
    <thead>
    <tr>
        <th>Ordinal numbers</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${emailList}" varStatus="ordinal_numbers">
        <tr>
            <td>${ordinal_numbers.count}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td><input type="checkbox" <c:if test="${email.spamFilter}">checked</c:if> disabled></td>
            <td>${email.signature}</td>
            <td><a href="/update?id=${email.id}" class="btn btn-sm btn-warning" role="button">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>

</script>
</body>
</html>