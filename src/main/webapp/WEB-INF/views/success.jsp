<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gaoshou</title>

</head>
<body>
        <h4>Success Page</h4>
        time: ${requestScope.time}
        <br><br>
        names:${requestScope.names}

        <br><br>
        request user:${requestScope.user}

        <br><br>
        session user:${sessionScope.user}

        <br><br>
        request school:${requestScope.school}

        <br><br>
        session school:${sessionScope.school}

</body>
</html>
