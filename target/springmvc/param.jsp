<%--
  Created by IntelliJ IDEA.
  User: 吴明言
  Date: 2020/5/31
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定--%>
    <%--
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>  --%>
    <form action="param/saveAccount" method="post">
        姓名:<input type="text" name="name"><br>
        密码:<input type="password" name="password"><br>
        金额:<input type="text" name="money"><br>
        <!-- 引用类型的封装-->
        兴趣爱好:<input type="text" name="user.hobby"><br>
        年龄:<input type="text" name="user.age"><br>

        <!--集合类型赋值-->
        爱好2:<input type="text" name="users[0].hobby"><br>
        年龄2:<input type="text" name="users[0].age"><br>

        爱好3:<input type="text" name="map[0].hobby"><br>
        年龄3:<input type="text" name="map[0].age"><br>

        <input type="submit" value="提交">

    </form>

    <a href="param/testServlet">Servlet原生的API</a>
</body>
</html>
