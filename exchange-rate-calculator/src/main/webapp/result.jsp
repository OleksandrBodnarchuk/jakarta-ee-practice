<%@ page import="pl.alex.exchangeratecalculator.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="pl.alex.exchangeratecalculator.ExchangeType" %><%--
  Created by IntelliJ IDEA.
  User: oleksandrbodnarchuk
  Date: 16.10.2021
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
        <%
            ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
            BigDecimal base = exchangeResult.getBase();
            BigDecimal result = exchangeResult.getResult();
            ExchangeType type = exchangeResult.getType();
            String baseCurrency = type.getBase();
            String targetCurrency = type.getTarget();

        %>
        <h2>
            <%=String.format("%s%s to %s%s",base.toString(),baseCurrency,result.toString(),targetCurrency)%>
        </h2>
</body>
</html>
