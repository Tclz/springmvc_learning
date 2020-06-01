<%--
  Created by IntelliJ IDEA.
  User: 吴明言
  Date: 2020/5/31
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <h3>入门程序</h3>
    <%--
    <a href="hello">入门程序</a>
    --%>
    <a href="user/testRequestMapping">RequestMapping注解</a><br>
    <!-- 常用的注解  RequestParam-->
    <a href="anno/testRequestParam?name=haha">RequestParam</a><br>
    <!-- RequestBody-->
    <form action="anno/testRequestBody" method="post">
        姓名:<input type="text" name="username"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <a href="anno/testPathVariable/10">PathVariable</a><br>
    <!-- RequestHeader-->
    <a href="anno/testRequestHeader">RequestHeader</a><br>
    <!-- CookieValue-->
    <a href="anno/testCookieValue">CookieValue</a><br>
    <!--ModelAttribute-->
    <form action="anno/testModelAttribute" method="post">
        爱好:<input type="text" name="hobby"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <!--SessionAttributes-->
    <a href="anno/testSessionAttributes">testSessionAttributes</a><br>
    <a href="anno/getSessionAttributes">getSessionAttributes</a><br>
    <a href="anno/delSessionAttributes">delSessionAttributes</a><br>

</head>
<body>

</body>
</html>
