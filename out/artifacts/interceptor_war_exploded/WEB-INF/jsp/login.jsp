<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
<%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
<div id="loginDiv" style="height: 350px">
    <form action="${pageContext.request.contextPath}/login" id="form">
        <h1 id="loginMsg">登录</h1>
        <center ><font color="red"><div id="errorMsg">${login_msg} ${register_msg}</div></font></center>
        <p>   email:<input id="email" name="email" type="text" required></p>

        <p>Password:<input id="password" name="password" type="password" required></p>
        <span style="color: red; font-weight: bold">${err}</span>
        <p>Remember:<input id="remember" name="remember" type="checkbox" ></p>

        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/toregister">没有账号？-> 注册</a>
        </div>
    </form>
</div>

</body>
</html>
