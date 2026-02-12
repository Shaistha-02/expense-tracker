<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*, com.expensetracker.model.Expense" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>View Expenses</title>
</head>
<body>

<h2>Your Expenses</h2>


<table border="1" cellpadding="8">
    <tr>
        <th>Title</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Date</th>
    </tr>

    <c:forEach var="e" items="${expenses}">
        <tr>
            <td>${e.title}</td>
            <td>${e.category}</td>
            <td>${e.amount}</td>
            <td>${e.expenseDate}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="dashboard">Back to Dashboard</a>

</body>
</html>
   