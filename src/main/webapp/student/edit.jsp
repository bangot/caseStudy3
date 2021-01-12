<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/12/2021
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="student?action=student">List All Student</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Sex:</th>
                <td>
                    <input type="text" name="sex" size="45"
                           value="<c:out value='${user.sex}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${student.country}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
