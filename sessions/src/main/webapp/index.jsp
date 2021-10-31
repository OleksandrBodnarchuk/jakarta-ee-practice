<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: oleksandrbodnarchuk
  Date: 17.10.2021
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>Nawodnienie</title>
</head>
    <h1>śledzenie poziomu nawodnienia</h1>
    <form action="control">
        <button name="option" value="water">Dodaj szklanke wody</button>
        <button name="option" value="clear">Wyzeruj licznik</button>
    </form>

    <%
        Object water = request.getSession().getAttribute("water");
        if (water==null){
    %>
    <h2>No water consumed today!</h2>
<%
    }else {
%>
    <h2>Drinked <%=water%>ml of wootah</h2>
<% }
%>

<body>

</body>
</html>
