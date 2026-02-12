<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Expense Tracker</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/index.css">
    
</head>
<body>
<!-- NAVBAR -->
<div class="navbar">
    <div class="logo">
        Daily Expense Tracker Management
    </div>

    <div class="menu">
        <a href="index.jsp" class="active">Home</a>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
    </div>
</div>

<!-- HERO SECTION -->
<div class="hero">
    <h1>Welcome To Daily Expense Tracker Management</h1>
    <p>Track your daily expenses easily and stay financially organized</p>

    <div class="buttons">
        <a href="login.jsp" class="btn primary">Get Started</a>
        <a href="register.jsp" class="btn secondary">Create Account</a>
    </div>
</div>
<!-- FOOTER -->
<div class="footer">
    Daily Expense Tracker | Built using Java, JSP & MySQL
</div>

</body>
</html>



