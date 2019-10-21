<%--
  Created by IntelliJ IDEA.
  User: quan.vd173320
  Date: 10/14/2019
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
    <div class="title-site">Danh sách từ của ${loginedUser.userName}</div>
    <p style="color: red">${errorString}</p>
    <table border="1" cellpadding="5" cellspacing="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mean</th>
            <th>Key</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${wordList}" var="word">
            <tr>
                <td>${word.word_id}</td>
                <td>${word.word_name}</td>
                <td>${word.word_mean}</td>
                <td>${word.word_key}</td>
                <td>
                    <a href="editWord?word_id=${word.word_id}">Edit</a>
                </td>
                <td>
                    <a href="deletWord?word_id=${word.word_id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <a href="creatWord">New word</a>
    </table>
<%@ include file="footer.jsp"%>