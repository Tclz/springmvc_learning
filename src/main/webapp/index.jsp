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

    <!--文件上传 传统方式 -->
    <p>传统方式文件上传</p>
    <form action="user/fileUpLoad1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <!-- 文件上传 springMVC方式-->
    <p>SpringMVC文件上传</p>
    <form action="user/fileUpLoad2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="uploadFile"><br>
        <input type="submit" value="上传">
    </form>

    <!-- 跨服务器文件上传 springMVC方式-->
    <p>跨服务器文件上传</p>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload3"><br>
        <input type="submit" value="上传">
    </form>

    <a href="user/testInterceptor">拦截器</a><br>

    <a href="person/findAll">查询所有人员信息</a><br>

    <form action="person/save" method="post">
        <input type="text" name="name">
        <input type="text" name="money">
        <input type="submit" name="保存">
    </form>


</head>
<body>

</body>
</html>
