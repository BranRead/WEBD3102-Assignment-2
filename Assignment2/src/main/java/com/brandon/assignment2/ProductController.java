package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.brandon.assignment2.dao.DisplayProductsDAO;
import com.brandon.assignment2.database.DisplayProductsDAOImp;
import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.Review;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ProductControllerServlet", value = "/index.jsp")
public class ProductController extends HttpServlet {
    DisplayProductsDAOImp displayProductsDAOImp = new DisplayProductsDAOImp();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Review> reviews = displayProductsDAOImp.selectAllReviews(Integer.parseInt(request.getParameter("id")));
            double averageRating = 0;
            for (Review review:
                 reviews) {
                    averageRating += review.getScore();
            }
            averageRating /= reviews.size();
            request.getSession().setAttribute("reviews", reviews);
            request.getSession().setAttribute("averageRating", averageRating);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/reviews.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("/reviews.jsp");
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}