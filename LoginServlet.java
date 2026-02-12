package com.expensetracker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.login(email, password);

//        if (user != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            response.sendRedirect("dashboard.jsp");
//        } else {
//            response.sendRedirect("login.jsp");
//        }
        if (user != null) {
        	HttpSession session = request.getSession();
//        	session.setAttribute("user", user);
        	session.setAttribute("userId", user.getId());
        	response.sendRedirect("dashboard");


        } else {
        	request.setAttribute("error", "Invalid credentials");
            response.sendRedirect("login.jsp?error=1");
        }
    }
}

