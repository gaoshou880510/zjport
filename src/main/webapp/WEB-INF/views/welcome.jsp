<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    请开启你的表演
    From request Scope name:${requestScope.name}
    <br/>
    From request Scope age by Map:${requestScope.age}
    <br/>
    From request Scope age by Model:${requestScope.mail}
    <br/>
    From request Scope age by ModelMap:${requestScope.city}
    <br/>
    From session Scope age by ModelMap:${sessionScope.city}
    <a href="result">Result</a>
</body>
</html>