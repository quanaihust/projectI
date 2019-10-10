<%--
  Created by IntelliJ IDEA.
  User: quan.vd173320
  Date: 10/9/2019
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="all" >
<link rel="stylesheet" href="js/bootstrap.js" type="text/css" media="all" >
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<head></head>
<body>
    <div class="header">
        <div class="container">
            <div class="row head-top">
                <div class="col-md-8">
                    <ul class="head-selection">
                        <li class="head-select">
                            <a href="index.jsp">Tra cứu</a>
                        </li>
                        <li class="head-select">
                            <a href="#">Danh sách</a>
                        </li>
                        <li class="head-select">
                            <a href="#">Thêm từ</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <div class="login">
                        <a href="#">
                            <div class="icon-img icon-login1"></div>
                            <span class="">Đăng nhập</span>
                        </a>
                    </div>
                    <div class="login">
                        <a href="#">
                            <div class="icon-img icon-login2"></div>
                            <span class="">Đăng ký</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="title-site">Tra từ</div>
        <div class="box-search">
            <div class="container">
                <form action="" method="post">
                    <input class="input-key" type="text" name="key">
                    <input class="button-search" type="submit" value="Tra từ">
                </form>
            </div>
        </div>
    </div>
</body>
