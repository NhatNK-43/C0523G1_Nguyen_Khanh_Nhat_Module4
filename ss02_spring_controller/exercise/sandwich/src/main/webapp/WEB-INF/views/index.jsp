<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
    <form action="/save" method="post">
        <h1>Sandwich Condiments</h1>
        <br>
        <input type="checkbox" name="lettuce" id="lettuce" value="lettuce">
        <label for="lettuce">Lettuce</label>

        <input type="checkbox" name="tomato" id="tomato" value="tomato">
        <label for="tomato">Tomato</label>

        <input type="checkbox" name="mustard" id="mustard" value="mustard">
        <label for="mustard">Mustard</label>

        <input type="checkbox" name="sprouts" id="sprouts" value="sprouts">
        <label for="sprouts">Sprouts</label>

        <hr>
        <button type="submit">Save</button>
        <p>Sandwich condiments: ${result}</p>
    </form>
</body>
</html>