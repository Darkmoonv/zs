<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/user/service09" enctype="multipart/form-data">
        名称<input type="text" name="name"><br>
        文件<input type="file" name="uploadFile"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
