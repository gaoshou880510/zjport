<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/18
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <strong>${message}</strong>
<form action="query.do" method="post">
    <p>
        <label>VIP:<input name="code" autofocus></label>
        <button type="submit">Go</button>
    </p>
</form>
</header>
<main>
    <c:if test="${v!=null}">
    <article>
        <p>
            <span>
                编号：
                <b>${v.code}</b>
            </span>
            <span>
                VIP等级：
                <b>${v.rank}</b>
            </span>
            <span>
                目前消费总金额：
                <b>￥${v.amount}元</b>
            </span>
        </p>

        <p>
            <span>
                姓名：
                <b>${v.name}</b>
            </span>
            <span>
                性别：
                <b>${v.sex}</b>
            </span>
            <span>
                年龄：
                <b>${v.age}</b>
            </span>
        </p>

        <p>
            <span>
                QQ：
                <b>${v.qq}</b>
            </span>
            <span>
                Email：
                <b>${v.email}</b>
            </span>
            <span>
                邮寄地址/邮编：
                <b>${v.address}/${v.zip}</b>
            </span>
        </p>
    </article>
    </c:if>
</main>


</body>
</html>
