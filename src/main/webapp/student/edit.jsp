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
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.name}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Sex:</th>
                <td>
                    <input type="text" name="sex" size="45"
                           value="<c:out value='${user.sex}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>testScore:</th>
                <td>
                    <input type="text" name="testScore" size="15"
                           value="<c:out value='${student.testScore}' />"
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
