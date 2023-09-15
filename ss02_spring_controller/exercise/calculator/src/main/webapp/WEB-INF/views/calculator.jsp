<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <style>
    </style>
</head>
<body>
    <h1>Calculator</h1>
    <br/>
    <form action="/calculator" method="post">
        <table>
            <tbody>
            <tr>
                <td colspan="2"><label for="number1">Number 1st</label></td>
                <td colspan="2"><label for="number2">Number 2nd</label></td>
            </tr>
            <tr>
                <td colspan="2"><input type="number" name="number1" id="number1" value="${number1}" required></td>
                <td colspan="2"><input type="number" name="number2" id="number2" value="${number2}" required></td>
            </tr>
            <tr>
                <td><button type="submit" name="operator" value="Addition">Addition(+)</button></td>
                <td><button type="submit" name="operator" value="Subtraction">Subtraction(-)</button></td>
                <td><button type="submit" name="operator" value="Multiplication">Multiplication(x)</button></td>
                <td><button type="submit" name="operator" value="Division">Division(/)</button></td>
            </tr>
            <tr>
                <td colspan="4">${result}</td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>