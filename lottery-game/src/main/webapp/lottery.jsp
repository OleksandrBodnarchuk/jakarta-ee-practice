<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.alex.lotterygame.LotteryDTO" %><%--
  Created by IntelliJ IDEA.
  User: oleksandrbodnarchuk
  Date: 16.10.2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loteria</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<%
    LotteryDTO lotteryDTO = (LotteryDTO) request.getAttribute("lotteryDTO");
    String numbersGenerated = lotteryDTO.getRandom().toString();
    String numbersReceived = lotteryDTO.getReceived().toString();
    Integer equalNumbers = lotteryDTO.getWinnerNumbers().size();
    String winningNumbers;
    if (lotteryDTO.getWinnerNumbers().isEmpty()){
        winningNumbers = "Brak!";
    }else {
        winningNumbers = lotteryDTO.getWinnerNumbers().toString();
    }
%>
<main>
    <h1>Wynik losowania: <%=numbersGenerated%></h1>
    <h1>Twoje liczby: <%=numbersReceived%></h1>
    <h1>Liczba trafień: <%=equalNumbers%></h1>
    <h1>Trafione liczby: <%=winningNumbers%></h1>
</main>
</body>
</html>