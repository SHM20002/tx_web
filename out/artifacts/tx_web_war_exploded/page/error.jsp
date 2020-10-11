<%--
  Created by IntelliJ IDEA.
  User: 似是故人来
  Date: 2020/9/23
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="10;url=index.html">
    <title>error</title>
    <link rel="stylesheet" href="css/error.css" type="text/css" charset="utf-8">
    <link href="css/style.css" rel="stylesheet" type="text/css" charset="UTF-8" />
</head>
<body>
    <div class="container">
        <div class="nav">
            <h1>Error Page</h1>
        </div>
        <hr />
        <div class="error_img">
            <img src="images/error_img.jpg" alt="">
        </div>
        <div class="box">
            <h3 class="error_info">${errorMsg}</h3>
            <h4><span id="secs_Now">10</span>秒后自动返回到登录页面！！！</h4>
            <h4>不能跳转，请<a href="javascript:void(0)" id="jump" >点击这儿</a></h4>
        </div>
    </div>
<script src="js/error.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
