<%--
  Created by IntelliJ IDEA.
  User: quan.vd173320
  Date: 10/11/2019
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="control.LoginServlet" %>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<%@ include file="header.jsp" %>
<main>
    <div class="title-site">Đăng nhập</div>
    <div class="box-sign-in">
        <div class="container">
            <p style="text-align: center">${errorString}</p>
            <form method="post" action="${pageContext.request.contextPath}/login">
                <div class="sign-in">
                    <div class="title-box">Tên đăng nhập</div>
                    <span>
                            <input type="text" name="userName" value="${user.userName}">
                        </span>
                </div>
                <div class="sign-in">
                    <div class="title-box">Mật khẩu</div>
                    <span>
                        <input type="text" name="password" value="${user.password}">
                    </span>
                </div>
                <div class="sign-in">
                    <span class="title-box">Nhớ tài khoản</span>
                    <span>
                         <input type="checkbox" name="rememberMe" value="Y">
                    </span>
                </div>
                <div class="button-box">
                    <input type="submit" value="Đăng nhập">
                </div>
            </form>
        </div>
    </div>
</main>
</body>
