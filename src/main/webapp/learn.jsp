<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>浙江电子口岸有限公司</title>
</head>
<body>
<a href="springmvc/testMethod">Test Method </a>
<br><br>

<a href="springmvc/testRequestMapping">Test RequestMapping</a>

<br><br>

<a href="/helloworld">Hello World</a>
<br><br>
<a href="/springmvc/testAntPath/ddd/abc">test AntPath</a>
<br><br>
<a href="springmvc/testPathVariable/1">test PathVariable</a>
<br><br>
<a href="/springmvc/testParamsAndHeaders?username=gaoshou&age=10">test ParamsAndHeaders</a>
<br><br>
<form action="/springmvc/testMethod" method="post">
    <input type="submit" value="submit">
</form

<br><br>
<a href="springmvc/testRest/1">Test Rest Get</a>

<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="TestRest PUT">
</form>

<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="TestRest DELETE">
</form>

<br><br>
<form action="springmvc/testRest" method="post">
    <input type="submit" value="TestRest POST">
</form>

<br><br>
<a href="springmvc/testRequestParam?username=gaoshou&age=30">test RequestParam</a>
<br><br>
<a href="springmvc/testRequestHeader">test RequestHeader</a>
<br><br>
<a href="springmvc/testCookieValue">test CookieValue</a>

<br><br>
<form action="springmvc/testPojo" method="post">
    username:<input type="text" name="username">
    <br>
    password:<input type="password" name="password">
    <br>
    email:<input type="text" name="email">
    <br>
    age:<input type="text" name="age">
    <br>
    city:<input type="text" name="address.city">
    <br>
    province:<input type="text" name="address.province">
    <br>
    <input type="submit" value="Submit">
</form>

    <a href="springmvc/testServletAPI">test ServletAPI</a>
    <br>
    <a href="springmvc/testModelAndView">test ModelAndView</a>
    <br>
    <a href="springmvc/testMap">test Map</a>
    <br>
    <a href="springmvc/testSessionAttributes">test SessionAttributes</a>

<br><br>
<form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1"/>
    username:<input type="text" name="username" value="Tom">
    <br>
    email:<input type="text" name="email" value="tom@atgui.com">
    <br>
    age:<input type="text" name="age" value="12">
    <br>
    <input type="submit" value="submit">
</form>


</body>
</html>
