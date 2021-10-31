<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaChat</title>
    <link rel="stylesheet" href="chat.css">
</head>
<body>
<header>
    <h1>Welcome in JavaChat!</h1>
    <p>Here is message history. Your can join as well</p>
</header>
<main>
    <c:choose>
        <c:when test="${not empty chat}">
            <ul class="message-list">
                <c:forEach items="${chat}" var="message">
                    <li><c:out value="${message}"/></li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise><h2>No messages yet!</h2></c:otherwise>
    </c:choose>
    <form action="" method="post">
        <label>
            <textarea name="message" placeholder="Your Message" rows="5" required></textarea>
        </label>
        <label>
            <input name="author" placeholder="Your name" required>
        </label>
        <button>Send</button>
    </form>
</main>
</body>
</html>