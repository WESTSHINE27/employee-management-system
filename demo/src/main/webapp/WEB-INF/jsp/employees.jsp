<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<nav class="navbar">
    <p class="logo">Employee Management System</p>
</nav>

<div class="employees-container">
    <h2>Employee List</h2>
    <a class="btn-add" href="/employees/new">Add Employee</a>

    <table class="employee-table">
        <thead>
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Phone No</th><th>Gender</th><th>Salary</th><th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.email}</td>
                    <td>${emp.phoneNo}</td>
                    <td>${emp.gender}</td>
                    <td><fmt:formatNumber value="${emp.salary}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                    <td>
                        <a class="btn-edit" href="/employees/edit/${emp.id}">Edit</a>
                        <a class="btn-delete" href="/employees/delete/${emp.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
