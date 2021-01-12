<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/12/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/student?action=create">Add New Student</a>>
    </h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
    <caption><h2>List of Student</h2></caption>
    <tr>
        <th>Id</th>
        <th>Name/th>
        <th>Sex</th>
        <th>TestScore</th>
    </tr>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td>c:out value="${student.id}"</td>
            <td>c:out value="${student.name}"</td>
            <td>c:out value="${student.sex}"</td>
            <td>c:out value="${student.testScore}"</td>
            <td>
                <a href="/student?action=edit&id=${student.id}">Edit</a>
                <a href="/student?action=edit&id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
