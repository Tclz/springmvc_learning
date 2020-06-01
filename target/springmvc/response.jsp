<%--
  Created by IntelliJ IDEA.
  User: 吴明言
  Date: 2020/6/1
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                   // alert("hello,friend.");
                // 发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charSet=UTF-8",
                    // 传给服务器的参数 json格式
                    data:'{"hobby":"hehe","age":12,"date":"2009-11-12"}',
                    // 返回类型
                    dataType:"json",
                    // 请求类型
                    type:"post",
                    success:function (data) {
                        // data是服务器端响应的数据，在这里进行解析
                        //alert(data);
                        alert(data.hobby);
                        alert(data.age);
                        alert(data.date);
                    }

                });




            });

        });
    </script>
</head>
<body>
        <a href="user/testString">testString</a><br>
        <a href="user/testVoid">testVoid</a><br>
        <a href="user/testModelAndView">testModelAndView</a><br>
        <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

        <button id="btn">发送Ajax请求</button>

</body>
</html>
