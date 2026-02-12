package com.expensetracker.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.dao.UserDAO;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        
          UserDAO dao=new UserDAO();
          String userName=dao.getUserNameById(userId);
          request.setAttribute("userName", userName);
          
          ExpenseDAO expensedao = new ExpenseDAO();

          request.setAttribute("todayTotal", expensedao.getTodayTotal(userId));
          request.setAttribute("yesterdayTotal", expensedao.getYesterdayTotal(userId));
          request.setAttribute("last7DaysTotal", expensedao.getLast7DaysTotal(userId));
          request.setAttribute("currentYearTotal", expensedao.getCurrentYearTotal(userId));
          request.setAttribute("totalExpense", expensedao.getTotalExpense(userId));

          request.getRequestDispatcher("dashboard.jsp").forward(request, response);

//        request.setAttribute("today", dao.getTodayTotal(userId));
//        request.setAttribute("last7", dao.getLast7DaysTotal(userId));
//        request.setAttribute("year", dao.getCurrentYearTotal(userId));
//        request.setAttribute("total", dao.getTotal(userId));

//        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
