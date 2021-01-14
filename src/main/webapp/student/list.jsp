<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/student?action=create">Add New Student</a>
    </h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
    <caption><h2>List of Student</h2></caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sex</th>
        <th>TestScore</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.sex}"/></td>
            <td><c:out value="${student.testScore}"/></td>
            <td>
                <a href="/student?action=edit&id=${student.id}">Edit</a>
                <a href="/student?action=delete&id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
