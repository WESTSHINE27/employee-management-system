<html>
<body>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<div class="create-container">
    <nav class="navbar">
        <p class="logo">Employee Management System</p>
    </nav>
    <h2>Create Employee</h2>
    <form action="${pageContext.request.contextPath}/employees" method="post" class="employee-form">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />

        <label for="phoneNo">Phone No:</label>
        <input type="text" id="phoneNo" name="phoneNo" required />

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" required />

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required />

        <button type="submit" class="btn-submit">Save</button>
    </form>
</div>
</body>
</html>
