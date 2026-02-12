<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ page import="com.expensetracker.model.User" %>
<%
Integer userId = (Integer) session.getAttribute("userId");
if (userId == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">
<style>
.card {
    display:inline-block;
    width:200px;
    margin:10px;
    padding:15px;
    border-radius:8px;
    background:#f4f6f8;
    text-align:center;
    box-shadow:0 0 5px #aaa;
}
.amount {
    font-size:22px;
    color:green;
    font-weight:bold;
}
</style>
</head>

<body>
<!-- NAVBAR -->
<div class="navbar">
    <div class="title">Daily Expense Tracker Management</div>
    <div class="nav-links">
        <a href="add-expense.jsp">Add Expense</a>
        <a href="viewExpense">View Expenses</a>
        <a href="logout">Logout</a>
    </div>
</div>

<!-- DASHBOARD -->
<div class="dashboard-container">

    <h2 class="welcome-text">
        Welcome, ${userName}
    </h2>

    <!-- SUMMARY CARDS -->
    <div class="card-grid">

        <div class="card">
            <p>Today</p>
            <h3>₹ ${todayTotal}</h3>
        </div>
        <div class="card">
            <p>Yesterday</p>
            <h3>₹ ${yesterdayTotal}</h3>
        </div>
        
        <div class="card">
            <p>Last 7 Days</p>
            <h3>₹ ${last7DaysTotal}</h3>
        </div>

        <div class="card">
            <p>Current Year</p>
            <h3>₹ ${currentYearTotal}</h3>
        </div>

        <div class="card">
            <p>Total</p>
            <h3>₹ ${totalExpense}</h3>
        </div>

    </div>

</div>

</body>
</html>