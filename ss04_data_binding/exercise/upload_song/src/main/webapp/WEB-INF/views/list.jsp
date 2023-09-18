<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 18/09/2023
  Time: 8:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách bài hát</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h2 class="text-primary">Danh sách bài hát</h2>
    <a href="/" class="btn btn-sm btn-secondary" role="button">Trở về</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên</th>
            <th scope="col">Người thể hiện</th>
            <th scope="col">Thể loại</th>
            <th scope="col">Đường dẫn</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songList}" var="song" varStatus="ordinalNumber">
            <tr>
                <th scope="row">${ordinalNumber.count}</th>
                <td>${song.name}</td>
                <td>${song.singer}</td>
                <td>${song.musicGenre}</td>
                <td>${song.pathMusic}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
