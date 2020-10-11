<%--
  Created by IntelliJ IDEA.
  User: 似是故人来
  Date: 2020/10/8
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link type="text/css" rel="stylesheet" href="css/main_style.css">

</head>
<body>
<div class="box">
    <div class="box_title">
				<span class="b_t_span">欢迎你：<span>${user.chrName}</span>
				<a id="exit_btn" href="exit.do">【安全退出】</a>
				</span>
    </div>

    <div class="box_nav">
        <div class="b_n_list">
            <ul>
                <li>首页</li>
                <li>
                    <a href="GetDownloadList.do">资源下载</a>
                </li>
                <li>
                    <a href="#">用户管理</a>
                </li>
                <li>
                    <a href="#">资源管理</a>
                </li>
                <li>
                    <a href="#">个人中心</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="box_context">
        <div class="b_c_box">

        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js" charset="UTF-8"/>
<script type="text/javascript" src="js/main_script.js" charset="UTF-8"/>
</body>
</html>