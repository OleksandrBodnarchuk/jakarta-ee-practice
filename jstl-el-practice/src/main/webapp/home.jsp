<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <div>
                <label for="gender">Gender</label>
                <select name="gender" id="gender">
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
            </div>
        </fieldset>
        <button type="submit">Submit Form</button>
    </form>

    <ol>
        <c:forEach items="${applicationScope.people}" var="person">
            <li>
                ${person.name} - ${person.surname} (${person.age} y.o)/
                ${person.gender=='MALE'?'Male':'Female'}
                <c:if test="${person.age>=18}">
                    <span style="color:green">Mature</span>
                </c:if>
                    <c:if test="${person.age<18}">
                        <span style="color:red">Teen</span>
                    </c:if>
            </li>
        </c:forEach>
    </ol>

</body>
</html>