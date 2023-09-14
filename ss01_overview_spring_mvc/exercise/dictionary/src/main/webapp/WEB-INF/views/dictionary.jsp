<%--
  Created by IntelliJ IDEA.
  User: Khanh Nhat
  Date: 14/09/2023
  Time: 4:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <style>
        label{
            font-weight: bold;
        }
    </style>
</head>
<body>
   <form action="/dictionary" method="post">
     <label for="englishWord">Nhập từ cần dịch</label>
     <input id="englishWord" name="englishWord" value="${englishWord}" type="text" required>
     <button type="submit">Dịch</button><br><br>
     <label for="englishWord">Kết quả dịch: </label> ${result}
   </form>
</body>
</html>
