<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Admin</title>
</head>
<body>
<h1>Cześć <%=request.getAttribute("username")%></h1>
<p>Here is your control panel: </p>
<ul>
    <li>Manage users</li>
    <li>Moderate items for others</li>
    <li>Analyze page data</li>
    <li>and more...</li>
</ul>
</body>
</html>