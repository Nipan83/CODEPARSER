<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="getInfo" method="post">
    <input type="radio" name="database" value="sql"> SQL
    <input type="radio" name="database" value="oracle"> Oracle<br>
    
    UserName:<input type="text" name="Name"><br>
    Password:<input type="password" name="Password"><br>
    IpAddress:<input type="text" name="IPAdd"><br>
    DatabaseName:<input type="text" name="DBName"><br>
    <button type="submit">Connect</button>
    


    </form>
</body>
</html>