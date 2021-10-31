<%--
  Created by IntelliJ IDEA.
  User: oleksandrbodnarchuk
  Date: 17.10.2021
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
    <h2>Note has been saved</h2>
    <a href="<%=request.getAttribute("noteUrl")%>">Check the note</a>
</body>
</html>
