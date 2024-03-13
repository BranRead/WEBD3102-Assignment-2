package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.brandon.assignment2.database.AddressDAOImp;
import com.brandon.assignment2.model.Address;
import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AddressControllerServlet", value = "/address")
public class AddressController extends HttpServlet {

    AddressDAOImp addressDAOImp = new AddressDAOImp();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            List<Address> addresses = addressDAOImp.select(user.getId());
            request.getSession().setAttribute("addresses", addresses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("order.jsp");
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}