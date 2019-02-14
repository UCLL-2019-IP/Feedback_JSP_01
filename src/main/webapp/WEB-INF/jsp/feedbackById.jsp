<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Feedback By ID - JSP version</title>
</head>
<body>
    <h1>Feedback</h1>
    <table>
        <thead>
            <th>Name</th>
            <th>Feedback</th>
        </thead>
        <tbody>

            <tr>
                <td>${feedback.name}</td>
                <td>${feedback.feedback}</td>
            </tr>

        </tbody>
    </table>
</body>
</html>