package com.brandon.assignment2;

import java.io.*;
import java.util.List;

import com.brandon.assignment2.database.DisplayProductsDAOImp;
import com.brandon.assignment2.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RefreshControllerServlet", value = "/index.jsp")
public class RefreshController extends HttpServlet {
    DisplayProductsDAOImp displayProductsDAOImp = new DisplayProductsDAOImp();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Product> products = displayProductsDAOImp.selectAll();
            request.getSession().setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("main.jsp");
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}