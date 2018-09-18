<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/16
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>高手</title>


</head>
<body>
    <header>
        <h1>高级搬砖工程师</h1>
        <span>
            <b>${sessionScope.currentUser.name} </b>
            <a href="logout.do">退出登入</a>
        </span>
    </header>
    <section>
        <menu></menu>
            <ul>
                <li>
                    <a href="query.do" target="mainFrame">VIP客户查询</a>
                </li>
                <li>
                    <a href="add.do" target="mainFrame">录入VIP客户</a>
                </li>
                <li>
                    <a href="learnMVC/13" target="mainFrame">自学MVC</a>
                </li>
                <li>
                     <a href="updatepassword.do" target="mainFrame">修改密码</a>
                </li>
            </ul>
        <main>
            <iframe name="mainFrame" src="welcome.do"></iframe>
        </main>
    </section>

    <form action="learnMVCparam" method="post">
        <p>
        <label>id:<input type="text" name="id"></label>
    </p>
        <p>
            <label>name:<input type="text" name="name"></label>
        </p>
        <p>
            <label>city:<input type="text" name="address.city"></label>
        </p>
        <p>
            <label>street:<input type="text" name="address.street"></label>
        </p>
            <button type="submit" value="SUBMIT">提交</button>
    </form>


    <br/>
    <br/>
    <form action="testModeAttribute" method="post">
        id:<input type="text" name="id" value="101">
        <br/>
        name:<input type="text" name="name" value="TOM">
        <input type="submit" value="UPDATE">
    </form>


    <form action="testFormat" method="post">
        Name:<input type="text" name="name">
        <br/>
        Age:<input type="text" name="age">
        <br/>
        Salary:<input type="text" name="salary">
        <br/>
        <input type="submit" value="submit">
    </form>

</body>
</html>
