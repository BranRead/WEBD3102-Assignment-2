package com.brandon.assignment2;

import com.brandon.assignment2.database.LoginDAOImp;
import com.brandon.assignment2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
    LoginDAOImp loginDAOImp;


    public void init() {
        loginDAOImp = new LoginDAOImp();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            select(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    private void select(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        User user = loginDAOImp.select(request.getParameter("username"), request.getParameter("password"));
        if(user != null) {
            request.setAttribute("user", user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("errorLoggingIn", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("/main.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errorLoggingIn", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("/main.jsp");
        }
    }
}