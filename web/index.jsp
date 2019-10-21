<%--
  Created by IntelliJ IDEA.
  User: quan.vd173320
  Date: 10/9/2019
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/header.jsp"%>
    <div class="main">
        <div style="text-align: center">Xin chào ${loginedUser.userName}</div>
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
<%@ include file="WEB-INF/footer.jsp"%>
