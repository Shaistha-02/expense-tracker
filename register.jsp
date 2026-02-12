<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
</head>
<body>
<!-- NAVBAR -->
<div class="navbar">
    <div class="title">Daily Expense Tracker Management</div>
    <div class="nav-links">
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
    </div>
</div>

<!-- PAGE CONTENT -->
<div class="page-container">
    <div class="form-card">
        <h2>Register Here</h2>

        <form action="RegisterServlet" method="post">

            <div class="form-group">
                <label>Name</label>
                <input type="text" name="firstName" placeholder="Enter First Name" required>
            </div>

            <div class="form-group">
                <label>Email address</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>


            <div class="btn-group">
                <button class="btn btn-submit">Submit</button>
                <button type="reset" class="btn btn-reset">Reset</button>
            </div>
        </form>
        <p class="login-link">
            Already have an account?
            <a href="login.jsp">Login Here</a>
        </p>
        </div>
</div>

</body>
</html>