<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Feedbacks - JSP version</title>
</head>
<body>
    <h1>Feedbacks</h1>
    <table>
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Feedback</th>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${feedbacks}">
            <tr>
                <td>${feedback.id}</td>
                <td>${feedback.name}</td>
                <td>${feedback.feedback}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>