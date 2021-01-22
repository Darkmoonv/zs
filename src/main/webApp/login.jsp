<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/user/login">
        请输入用户名<input type="text" name="username">
        请输入密码<input type="text" name="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
