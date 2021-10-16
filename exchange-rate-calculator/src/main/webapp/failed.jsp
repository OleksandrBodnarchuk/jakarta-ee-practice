<%--
  Created by IntelliJ IDEA.
  User: oleksandrbodnarchuk
  Date: 16.10.2021
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failed</title>
</head>
<body>
<h1>Wystąpił błąd</h1>
<p>
    <%=request.getAttribute("message")%>
</p>
</body>
</html>
