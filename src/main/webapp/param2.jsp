<%--
  Created by IntelliJ IDEA.
  User: 吴明言
  Date: 2020/5/31
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--自定义类型转换  String转Date-->
    <!-- 例如只能适配2009/11/06这样的格式  不支持2009-11-06  故需要实现一个类型转换器-->
    <form action="param/saveUser" method="post">

        兴趣爱好:<input type="text" name="hobby"><br>
        年龄:<input type="text" name="age"><br>
        生日:<input type="text" name="date"><br>
        <input type="submit" value="提交">

    </form>

</body>
</html>
