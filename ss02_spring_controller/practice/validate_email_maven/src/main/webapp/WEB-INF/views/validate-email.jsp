<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 15/09/2023
  Time: 10:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Validate Email</title>
  <style>
    p{
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>
<form action="/validate" method="post">
  <h2>Validate email</h2>
  <label for="inputEmail">Enter email: </label>
  <input type="email" id="inputEmail" name="inputEmail" value="${inputEmail}" required>
  <button type="submit">Check</button>
  <p>${message}</p>
</form>
</body>
</html>
