<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 18/09/2023
  Time: 2:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Box</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<br/>


<%--@elvariable id="email" type="com"--%>
<form:form modelAttribute="email" action="/update?id=${email.id}" method="post">
    <table>
        <tbody>
        <tr>
            <td class="fw-bold">Languages</td>
            <td>
                <form:select path="language" items="${languageList}"/>
            </td>
        </tr>
        <tr>
            <td class="fw-bold">Page Size</td>
            <td>
                Show
                <form:select path="pageSize" items="${pageSizeList}"/> emails per page
            </td>
        </tr>
        <tr>
            <td class="fw-bold">Spams Filter</td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td class="fw-bold">Signature</td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button class="btn btn-sm btn-primary" type="submit">Update</button>
                <a href="/" type="button" class="btn btn-sm btn-outline-secondary">Cancel</a>
            </td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
