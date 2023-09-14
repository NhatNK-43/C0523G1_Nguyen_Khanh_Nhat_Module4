<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 14/09/2023
  Time: 2:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency conversion</title>
</head>
<body>
<form action="/currency" method="post">
    <fieldset>
        <legend>Currency conversion</legend>
        <table>
            <thead>
            <tr>
                <th><label for="usd">USD</label></th>
                <th></th>
                <th><label for="vnd">VND</label></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="number" min="0" id="usd" name="usd" value="${usd}" required></td>
                <td> = </td>
                <td><input type="number" id="vnd" name="vnd" value="${vnd}" disabled></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Convert</button>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
