<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Expense</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/addexpenses.css">
</head>
<body>
<div class="navbar">
    <div class="title">Daily Expense Tracker Management</div>
    <div class="nav-links">
        <a href="viewExpense">View Expenses</a>
        <a href="logout">Logout</a>
    </div>
</div>
<div class="page-container">

    <div class="form-card">
        <h2>Add Expenses</h2>

        <form action="addExpense" method="post">

            <div class="form-group">
                <label>Title</label>
                <input type="text" name="title" placeholder="Enter Item" required>
            </div>
            
            <div class="form-group">
                <label>Category</label>
                <input type="text" name="title" placeholder="Enter Item" required>
            </div>

            <div class="form-group">
                <label>Date</label>
                <input type="date" name="date" required>
            </div>

            <div class="form-group">
                <label>Price</label>
                <input type="number" name="amount" placeholder="Enter Price" required>
            </div>


            <button type="submit" class="btn-primary">Submit</button>

        </form>
    </div>

</div>
</body>
</html>