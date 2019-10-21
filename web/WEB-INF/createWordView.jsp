<%--
  Created by IntelliJ IDEA.
  User: quan.vd173320
  Date: 10/21/2019
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h3>Create Word</h3>
<form method="post" action="${pageContext.request.contextPath}/createWord">
    <table border="0">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${word.word_name}" /></td>
        </tr>
        <tr>
            <td>Mean</td>
            <td><input type="text" name="mean" value="${word.word_mean}" /></td>
        </tr>
        <tr>
            <td>Key</td>
            <td><input type="text" name="key" value="${word.word_key}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="myList">Cancel</a>
            </td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp"%>
