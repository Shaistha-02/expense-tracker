<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
<!-- NAVBAR -->
<div class="navbar">
    <div class="title">Daily Expense Tracker Management</div>
    <div class="nav-links">
        <a href="index.jsp">Home</a>
        <a href="register.jsp">Sign Up</a>
    </div>
</div>

<!-- LOGIN FORM -->
<div class="page-container">
    <div class="form-card">

        <h2>Sign In</h2>

        <form action="login" method="post">

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" placeholder="Enter email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter password" required>
            </div>

            <div class="btn-group">
                <button type="submit" class="btn btn-submit">Login</button>
                <button type="reset" class="btn btn-reset">Reset</button>
            </div>

        </form>

        <p class="register-link">
            Don’t have an account?
            <a href="register.jsp">Create Account</a>
        </p>

    </div>
</div>
</body>
</html>