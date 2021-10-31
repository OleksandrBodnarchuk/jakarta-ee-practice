<jsp:useBean id="person" scope="request" type="pl.alex.jstlelpractice.Person"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EL Temp Page</title>
</head>
<body>
    <h1>User data</h1>
    <form action="" method="post">
        <fieldset>
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="surname">Surname</label>
            <input type="text" id="surname" name="surname">
        </div>

        <div>
            <label for="age">Age</label>
            <input type="number" id="age" name="age" min="0">
        </div>

        </fieldset>
        <button type="submit">Submit Form</button>
    </form>

    <%
        if(request.getAttribute("person") != null) {
    %>
    <h2>Hi ${person.name}</h2>
    <p style="color: ${person.age gt 18 ? 'green' : 'red'}">
        ${person.age gt 18 ? 'You are mature' : 'You are teen'}
    </p>
    <p>Your browser info: ${header['user-agent']}</p>
    <%
        }
    %>
</body>
</html>