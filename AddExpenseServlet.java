package com.expensetracker.controller;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        String title = request.getParameter("title");
        String category = request.getParameter("category");
        double amount = Double.parseDouble(request.getParameter("amount"));
//        Date expenseDate = Date.valueOf(request.getParameter("date"));
        String dateStr = request.getParameter("date");

        if (dateStr == null || dateStr.trim().isEmpty()) {
            response.sendRedirect("addExpense.jsp?error=Date is required");
            return;
        }

        java.sql.Date expenseDate = java.sql.Date.valueOf(dateStr);

        Expense expense = new Expense(title, category, amount, expenseDate, userId);

        ExpenseDAO dao = new ExpenseDAO();
        boolean result = dao.addExpense(expense);

        if (result) {
            response.sendRedirect("viewExpense");
        }
        else {
        	response.sendRedirect("add-expense.jsp?error=1");
        }
	}
}

