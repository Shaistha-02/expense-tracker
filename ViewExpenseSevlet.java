package com.expensetracker.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;

@WebServlet("/viewExpense")
public class ViewExpenseSevlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        ExpenseDAO dao = new ExpenseDAO();
        List<Expense> expenses = dao.getExpensesByUser(userId);
//        System.out.println("DEBUG userId = " + userId);
//        System.out.println("DEBUG expenses size = " + expenses.size());

        request.setAttribute("expenses", expenses);
        request.getRequestDispatcher("view-expense.jsp").forward(request, response);
    }
}
