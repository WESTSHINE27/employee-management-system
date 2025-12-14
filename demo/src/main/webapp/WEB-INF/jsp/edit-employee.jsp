<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<nav class="navbar">
    <p class="logo">Employee Management System</p>
</nav>

<div class="create-container">
    <h2>Edit Employee</h2>
    <form action="${pageContext.request.contextPath}/employees/update" method="post" class="employee-form">
        <input type="hidden" name="id" value="${employee.id}"/>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" required/>

        <label for="phoneNo">Phone No:</label>
        <input type="text" id="phoneNo" name="phoneNo" value="${employee.phoneNo}" required/>

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" value="${employee.gender}" required/>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" value="${employee.salary}" step="0.01" required/>

        <button type="submit" class="btn-submit">Update</button>
    </form>
</div>
</body>
</html>
