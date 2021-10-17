<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
</head>
<body>
    <h1>Hello</h1>
    <h2>Your visits: <%=request.getAttribute("numberOfVisits")%></h2>
</body>
</html>