package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brandon.assignment2.model.ShoppingCartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CartControllerServlet", value = "/CartController-servlet")
public class CartController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if(request.getParameter("add") != null) {
                add(request, response);
            }

            if(request.getParameter("delete") != null) {
                delete(request, response);
            }

            if(request.getParameter("change") != null) {
                change(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (request.getSession().getAttribute("userID") == null) {
            if (request.getSession().getAttribute("shoppingCart") == null) {
                List<ShoppingCartItem> shoppingCart = new ArrayList<>();
                request.getSession().setAttribute("shoppingCart", shoppingCart);
            } else {

            }
        } else {

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (request.getSession().getAttribute("userID") == null) {

        } else {

        }
    }

    private void change(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (request.getSession().getAttribute("userID") == null) {

        } else {

        }
    }
}